/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RestPack;

import BeanPack.AddressBeanLocal;
import EntityPack.Tbladdress;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Albus
 */
@Path("address")
public class AddressResource {

    AddressBeanLocal addressBean = lookupAddressBeanLocal();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AddressResource
     */
    public AddressResource() {
    }
    
    @GET
    public Collection<Tbladdress> allAddresses()
    {
        return addressBean.allAddresses();
    }
    
    @POST
    @Path("addAddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddress(@PathParam("street") String street,@PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") String zip,@PathParam("cid") int cid)
    {
        addressBean.addAddress(street, city, state, zip, cid);
    }
    
    @GET
    @Path("getAddress/{aid}")
    public Tbladdress getAddress(@PathParam("aid") int aid)
    {
        return addressBean.getAddress(aid);
    }

    @POST
    @Path("updateAddress/{aid}/{street}/{city}/{state}/{zip}/{cid}")
    public void updateAddress(@PathParam("aid") int aid,@PathParam("street") String street,@PathParam("city") String city,@PathParam("state") String state,@PathParam("zip") String zip,@PathParam("cid") int cid)
    {
        addressBean.updateAddress(aid, street, city, state, zip, cid);
    }
    
    private AddressBeanLocal lookupAddressBeanLocal() {
        try {
            javax.naming.Context c = new InitialContext();
            return (AddressBeanLocal) c.lookup("java:global/Rest_App1/Rest_App1-ejb/AddressBean!BeanPack.AddressBeanLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
}
