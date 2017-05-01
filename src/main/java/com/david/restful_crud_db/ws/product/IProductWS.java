 
package com.david.restful_crud_db.ws.product;

import com.david.restful_crud_db.ws.Product;
import javax.ws.rs.core.Response;

 

public interface IProductWS {
    
    public Response add (Product product);
    
    public Response Update (Product product);
    
    public Response Delete (int id);
    
    public Product Find (int id);
}
