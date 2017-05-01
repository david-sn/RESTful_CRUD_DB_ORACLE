package com.david.restful_crud_db.DAO;

import com.david.restful_crud_db.entity.Product;

public interface IProductDAO {

    public void create(Product product);

    public void Update(int id, float price);

    public void Delete(int id);

    public Product Find(int id);

}
