/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestPack;

import BeanPack.CustomerBeanLocal;
import EntityPack.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * REST Web Service
 *
 * @author Albus
 */
@Path("generic")
public class GenericResource {

    CustomerBeanLocal customerBean = lookupCustomerBeanLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    @GET
    public Collection<Tblcustomer> allCustomer()
    {
        return customerBean.allCustomer();
    }
    
    @POST
    @Path("addCustomer/{fname}/{lname}")
    public void addCustomer(@PathParam("fname") String fname,@PathParam("lname") String lname)
    {
        customerBean.addCustomer(fname, lname);
    }
    
    @GET
    @Path("getCustomer/{cid}")
    public Tblcustomer getCustomer(@PathParam("cid") int cid)
    {
        return customerBean.getCustomer(cid);
    }

    @POST
    @Path("updateCustomer/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") int cid,@PathParam("fname") String fname,@PathParam("lname") String lname)
    {
        customerBean.updateCustomer(cid, fname, lname);
    }
    
    @DELETE
    @Path("deleteCustomer/{cid}")
    public void deleteCustomer(@PathParam("cid") int cid)
    {
        customerBean.deleteCustomer(cid);
    }
    
    private CustomerBeanLocal lookupCustomerBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (CustomerBeanLocal) c.lookup("java:global/Rest_App1/Rest_App1-ejb/CustomerBean!BeanPack.CustomerBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
