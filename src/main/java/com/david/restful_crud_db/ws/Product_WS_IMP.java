/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.david.restful_crud_db.ws;

import com.david.restful_crud_db.ServiceIMP.ProductDAO_IMP;
import com.david.restful_crud_db.ws.product.IProductWS;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author David Shire
 */
public class Product_WS_IMP implements IProductWS {

    ProductDAO_IMP productService = new ProductDAO_IMP();

    public ProductDAO_IMP getProductService() {
        return productService;
    }

    public void setProductService(ProductDAO_IMP productService) {
        this.productService = productService;
    }

    @Override
    public Response add(Product product) {
        com.david.restful_crud_db.entity.Product prEntity = MapperWS_TO_entit(product);

        productService.create(prEntity);
        return Response.status(Response.Status.CREATED).entity(prEntity).build();
    }

    @Override
    public Response Update(Product product) {
        productService.Update(product.getId(), product.getPrice());
        return Response.status(Response.Status.OK).entity(product).build();
    }

    @Override
    public Response Delete(int id) {
        productService.Delete(id);
        return Response.status(Response.Status.OK).entity(id).build();
    }

    @Override
    public Product Find(int id) {
        com.david.restful_crud_db.entity.Product Find = productService.Find(id);

        Product p = new Product();
        p.setId(Find.getId());
        p.setDescriptions(Find.getDescriptions());
        p.setName(Find.getName());
        p.setPrice(Find.getPrice());
        return p;

    }

    private com.david.restful_crud_db.entity.Product MapperWS_TO_entit(Product product) {
        com.david.restful_crud_db.entity.Product prEntity = new com.david.restful_crud_db.entity.Product();
        product.setId(prEntity.getId());
        product.setDescriptions(prEntity.getDescriptions());
        product.setName(prEntity.getName());
        product.setPrice(prEntity.getPrice());
        return prEntity;
    }
}
