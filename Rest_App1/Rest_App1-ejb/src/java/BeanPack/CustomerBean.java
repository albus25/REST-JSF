/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPack;

import EntityPack.Tblcustomer;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Albus
 */
@Stateless
public class CustomerBean implements CustomerBeanLocal {

    @PersistenceContext(unitName = "Rest_App1-ejbPU")
    private EntityManager em;

    @Override
    public Collection<Tblcustomer> allCustomer() {
        return em.createNamedQuery("Tblcustomer.findAll").getResultList();
    }

    @Override
    public void addCustomer(String fname, String lname) {
        Tblcustomer c = new Tblcustomer();
        c.setFname(fname);
        c.setLname(lname);
        
        em.persist(c);
    }

    @Override
    public void updateCustomer(int cid, String fname, String lname) {
        Tblcustomer c = em.find(Tblcustomer.class, cid);
        c.setCid(cid);
        c.setFname(fname);
        c.setLname(lname);
        
        em.merge(c);
    }

    @Override
    public Tblcustomer getCustomer(int cid) {
        return em.find(Tblcustomer.class, cid);
    }

    @Override
    public void deleteCustomer(int cid) {
        Tblcustomer c = em.find(Tblcustomer.class, cid);
        em.remove(c);
    }

    public void persist(Object object) {
        em.persist(object);
    }
}
