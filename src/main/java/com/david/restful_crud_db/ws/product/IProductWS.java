 
package com.david.restful_crud_db.ws.product;

import com.david.restful_crud_db.ws.Product;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

 
@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
public interface IProductWS {
    
    @POST
    @Path("/products")
    public Response add (Product product);
    
    @PUT
    @Path("/products")
    public Response Update (Product product);
    
    @DELETE
    @Path("/products/{id}")
    public Response Delete (@PathParam("id") int id);
    
    @GET
    @Path("/products/{id}")
    public Product Find (@PathParam("id") int id);
}
