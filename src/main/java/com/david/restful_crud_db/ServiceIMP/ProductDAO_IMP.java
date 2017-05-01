package com.david.restful_crud_db.ServiceIMP;

import com.david.restful_crud_db.DAO.IProductDAO;
import com.david.restful_crud_db.entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

public class ProductDAO_IMP implements IProductDAO {

    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void create(final Product product) {
        jdbcTemplate.execute(" insert into products values (?,?,?,?)", new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setInt(1, product.getId());
                ps.setString(2, product.getName());
                ps.setString(3, product.getDescriptions());
                ps.setInt(4, product.getPrice());

                return ps.execute();
            }
        });
    }

    @Override
    public void Update(final int id, final float price) {
        jdbcTemplate.execute(" update products set price=? where id=?", new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setFloat(1, price);
                ps.setInt(2, id);

                return ps.execute();
            }
        });
    }

    @Override
    public void Delete(final int id) {
        jdbcTemplate.execute(" delete from products where id=?", new PreparedStatementCallback() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {

                ps.setInt(1, id);

                return ps.execute();
            }
        });

    }

    @Override
    public Product Find(int id) {
        return (Product)jdbcTemplate.query("select* from products where id="+id, new RowMapper() {
            @Override
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {

                
                Product product=new Product();
                product.setId(rs.getInt(1));
                product.setDescriptions(rs.getString(3));
                product.setName(rs.getString(2));
                product.setPrice(rs.getInt(4));
                
                return product;
            }
        });
        
    }

}
