/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "tblcustomer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblcustomer.findAll", query = "SELECT t FROM Tblcustomer t"),
    @NamedQuery(name = "Tblcustomer.findByCid", query = "SELECT t FROM Tblcustomer t WHERE t.cid = :cid"),
    @NamedQuery(name = "Tblcustomer.findByFname", query = "SELECT t FROM Tblcustomer t WHERE t.fname = :fname"),
    @NamedQuery(name = "Tblcustomer.findByLname", query = "SELECT t FROM Tblcustomer t WHERE t.lname = :lname")})
public class Tblcustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cid")
    private Integer cid;
    @Basic(optional = false)
    @Column(name = "fname")
    private String fname;
    @Basic(optional = false)
    @Column(name = "lname")
    private String lname;
    @JoinTable(name = "tblcustsub", joinColumns = {
        @JoinColumn(name = "cid", referencedColumnName = "cid")}, inverseJoinColumns = {
        @JoinColumn(name = "sid", referencedColumnName = "sid")})
    @ManyToMany
    private Collection<Tblsubscription> tblsubscriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cid")
    private Collection<Tbladdress> tbladdressCollection;

    public Tblcustomer() {
    }

    public Tblcustomer(Integer cid) {
        this.cid = cid;
    }

    public Tblcustomer(Integer cid, String fname, String lname) {
        this.cid = cid;
        this.fname = fname;
        this.lname = lname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
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

    @XmlTransient
    public Collection<Tblsubscription> getTblsubscriptionCollection() {
        return tblsubscriptionCollection;
    }

    public void setTblsubscriptionCollection(Collection<Tblsubscription> tblsubscriptionCollection) {
        this.tblsubscriptionCollection = tblsubscriptionCollection;
    }

    @XmlTransient
    public Collection<Tbladdress> getTbladdressCollection() {
        return tbladdressCollection;
    }

    public void setTbladdressCollection(Collection<Tbladdress> tbladdressCollection) {
        this.tbladdressCollection = tbladdressCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblcustomer)) {
            return false;
        }
        Tblcustomer other = (Tblcustomer) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPack.Tblcustomer[ cid=" + cid + " ]";
    }
    
}
