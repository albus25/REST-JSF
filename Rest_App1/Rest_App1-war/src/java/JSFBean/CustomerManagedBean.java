/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBean;

import EntityPack.Tblcustomer;
import JerseyPack.CustomerJerseyClient;
import java.util.*;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Albus
 */
@Named(value = "customerManagedBean")
@RequestScoped
public class CustomerManagedBean {
    CustomerJerseyClient cjc = new CustomerJerseyClient();

    private int cid;
    private String fname,lname;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Collection<Tblcustomer> allCustomer()
    {
        Response response = cjc.allCustomer(Response.class);
        ArrayList<Tblcustomer> clist = new ArrayList<Tblcustomer>();
        GenericType<Collection<Tblcustomer>> gCust = new GenericType<Collection<Tblcustomer>>(){};
        clist = (ArrayList<Tblcustomer>) response.readEntity(gCust);
        return clist;
    }
    
    public String addCustomer()
    {
        if(cid!=0)
        {
            cjc.updateCustomer(cid+"", fname, lname);
        }
        else
        {
            cjc.addCustomer(fname, lname);            
        }
        
        return "index.xhtml";
    }
    
    public String getCustomer(int cid)
    {
        Response response = cjc.getCustomer(Response.class, cid+"");
        GenericType<Tblcustomer> gCust = new GenericType<Tblcustomer>(){};
        Tblcustomer c = response.readEntity(gCust);
        this.cid = c.getCid();
        fname = c.getFname();
        lname = c.getLname();
        
        return "addCustomer.xhtml";
    }

    public String deleteCustomer(int cid)
    {
        cjc.deleteCustomer(cid+"");
        
        return "index.xhtml";
    }
    
    public CustomerManagedBean() {
    }
    
}
