/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "tbladdress")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tbladdress.findAll", query = "SELECT t FROM Tbladdress t"),
    @NamedQuery(name = "Tbladdress.findByAid", query = "SELECT t FROM Tbladdress t WHERE t.aid = :aid"),
    @NamedQuery(name = "Tbladdress.findByStreet", query = "SELECT t FROM Tbladdress t WHERE t.street = :street"),
    @NamedQuery(name = "Tbladdress.findByCity", query = "SELECT t FROM Tbladdress t WHERE t.city = :city"),
    @NamedQuery(name = "Tbladdress.findByState", query = "SELECT t FROM Tbladdress t WHERE t.state = :state"),
    @NamedQuery(name = "Tbladdress.findByZip", query = "SELECT t FROM Tbladdress t WHERE t.zip = :zip")})
public class Tbladdress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "aid")
    private Integer aid;
    @Basic(optional = false)
    @Column(name = "street")
    private String street;
    @Basic(optional = false)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @Column(name = "state")
    private String state;
    @Basic(optional = false)
    @Column(name = "zip")
    private String zip;
    @JoinColumn(name = "cid", referencedColumnName = "cid")
    @ManyToOne(optional = false)
    private Tblcustomer cid;

    public Tbladdress() {
    }

    public Tbladdress(Integer aid) {
        this.aid = aid;
    }

    public Tbladdress(Integer aid, String street, String city, String state, String zip) {
        this.aid = aid;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
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

    public Tblcustomer getCid() {
        return cid;
    }

    public void setCid(Tblcustomer cid) {
        this.cid = cid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aid != null ? aid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tbladdress)) {
            return false;
        }
        Tbladdress other = (Tbladdress) object;
        if ((this.aid == null && other.aid != null) || (this.aid != null && !this.aid.equals(other.aid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPack.Tbladdress[ aid=" + aid + " ]";
    }
    
}
