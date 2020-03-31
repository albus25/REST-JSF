/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPack;

import EntityPack.Tbladdress;
import java.util.*;
import javax.ejb.Local;

/**
 *
 * @author Albus
 */
@Local
public interface AddressBeanLocal {
    public Collection<Tbladdress> allAddresses();
    public void addAddress(String street,String city,String state,String zip,int cid);
    public void updateAddress(int aid,String street,String city,String state,String zip,int cid);
    public Tbladdress getAddress(int aid);
}
