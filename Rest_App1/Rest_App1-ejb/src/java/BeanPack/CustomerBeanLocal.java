/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPack;

import EntityPack.Tblcustomer;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author Albus
 */
@Local
public interface CustomerBeanLocal {
    public Collection<Tblcustomer> allCustomer();
    public void addCustomer(String fname,String lname);
    public void updateCustomer(int cid,String fname,String lname);
    public Tblcustomer getCustomer(int cid);
    public void deleteCustomer(int cid);
}
