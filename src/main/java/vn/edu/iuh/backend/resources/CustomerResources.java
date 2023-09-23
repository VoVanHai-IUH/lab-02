package vn.edu.iuh.backend.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.backend.models.Customer;
import vn.edu.iuh.backend.models.Employee;
import vn.edu.iuh.backend.services.CustomerServices;

import java.util.List;

@Path("/customers")
public class CustomerResources {
    private final  CustomerServices customerServices = new CustomerServices();
    @POST
//    @Produces("application/json")
    @Consumes("application/json")
    public Response insert(Customer customer) {
        customerServices.insertCust(customer);
        return Response.ok(customer).build();
    }

    @GET
    @Produces("application/json")
    public Response getAll(){
        List<Customer> lst = customerServices.getAll();
        return Response.ok(lst).build();
    }
}
