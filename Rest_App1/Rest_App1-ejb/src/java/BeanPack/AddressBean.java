/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPack;

import EntityPack.*;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Albus
 */
@Stateless
public class AddressBean implements AddressBeanLocal {

    @PersistenceContext(unitName = "Rest_App1-ejbPU")
    private EntityManager em;

    @Override
    public Collection<Tbladdress> allAddresses() {
        return em.createNamedQuery("Tbladdress.findAll").getResultList();
    }

    @Override
    public void addAddress(String street, String city, String state, String zip, int cid) {
        Tbladdress a = new Tbladdress();
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        
        Tblcustomer c = em.find(Tblcustomer.class, cid);
        Collection<Tbladdress> ca = c.getTbladdressCollection();
        a.setCid(c);
        
        ca.add(a);
        em.merge(c);
        
        em.persist(a);
    }

    @Override
    public void updateAddress(int aid, String street, String city, String state, String zip, int cid) {
        Tbladdress a = em.find(Tbladdress.class, aid);
        a.setAid(aid);
        a.setStreet(street);
        a.setCity(city);
        a.setState(state);
        a.setZip(zip);
        
        Tblcustomer c = em.find(Tblcustomer.class,cid);
        Collection<Tbladdress> ca = c.getTbladdressCollection();
        a.setCid(c);
        
        ca.add(a);
        em.merge(c);
        
        em.merge(a);
    }

    @Override
    public Tbladdress getAddress(int aid) {
        return em.find(Tbladdress.class, aid);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
