/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBean;

import BeanPack.CustomerBean;
import BeanPack.CustomerBeanLocal;
import EntityPack.*;
import JerseyPack.AddressJerseyClient;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Albus
 */
@Named(value = "addressManagedBean")
@RequestScoped
public class AddressManagedBean {

    @EJB
    private CustomerBeanLocal customerBean;
    AddressJerseyClient ajc = new AddressJerseyClient();
    /**
     * Creates a new instance of AddressManagedBean
     */
    
    private int aid,cid;
    private String street,city,state,zip;
    private Collection<Tblcustomer> clist;

    public Collection<Tblcustomer> getClist() {
        return clist;
    }

    public void setClist(Collection<Tblcustomer> clist) {
        this.clist = clist;
    }
    
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public AddressManagedBean() {
    }
    
    public Collection<Tbladdress> allAddresses()
    {
        Response response = ajc.allAddresses(Response.class);
        ArrayList<Tbladdress> alist = new ArrayList<Tbladdress>();
        GenericType<Collection<Tbladdress>> gAdd = new GenericType<Collection<Tbladdress>>(){};
        alist = (ArrayList<Tbladdress>) response.readEntity(gAdd);
        return alist;
    }
    
    @PostConstruct
    public void init()
    {
        clist = customerBean.allCustomer();
    }
    
    public String addAddress()
    {
        if(aid!=0)
        {
            ajc.updateAddress(aid+"", street, city, state, zip, cid+"");
        }
        else
        {
            ajc.addAddress(street, city, state, zip, cid+"");
        }
        return "addressIndex.xhtml";
    }
    
    public String getAddress(String aid)
    {
        Response response = ajc.getAddress(Response.class, aid);
        GenericType<Tbladdress> gAdd = new GenericType<Tbladdress>(){};
        Tbladdress a = response.readEntity(gAdd);
        this.aid = a.getAid();
        street = a.getStreet();
        city = a.getCity();
        state = a.getState();
        zip = a.getZip();
        cid = a.getCid().getCid();
        
        return "addAddress.xhtml";
    }
}
