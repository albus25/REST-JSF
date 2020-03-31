/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityPack;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Albus
 */
@Entity
@Table(name = "tblsubscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tblsubscription.findAll", query = "SELECT t FROM Tblsubscription t"),
    @NamedQuery(name = "Tblsubscription.findBySid", query = "SELECT t FROM Tblsubscription t WHERE t.sid = :sid"),
    @NamedQuery(name = "Tblsubscription.findByTitle", query = "SELECT t FROM Tblsubscription t WHERE t.title = :title"),
    @NamedQuery(name = "Tblsubscription.findByType", query = "SELECT t FROM Tblsubscription t WHERE t.type = :type")})
public class Tblsubscription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sid")
    private Integer sid;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @ManyToMany(mappedBy = "tblsubscriptionCollection")
    private Collection<Tblcustomer> tblcustomerCollection;

    public Tblsubscription() {
    }

    public Tblsubscription(Integer sid) {
        this.sid = sid;
    }

    public Tblsubscription(Integer sid, String title, String type) {
        this.sid = sid;
        this.title = title;
        this.type = type;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlTransient
    public Collection<Tblcustomer> getTblcustomerCollection() {
        return tblcustomerCollection;
    }

    public void setTblcustomerCollection(Collection<Tblcustomer> tblcustomerCollection) {
        this.tblcustomerCollection = tblcustomerCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sid != null ? sid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tblsubscription)) {
            return false;
        }
        Tblsubscription other = (Tblsubscription) object;
        if ((this.sid == null && other.sid != null) || (this.sid != null && !this.sid.equals(other.sid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityPack.Tblsubscription[ sid=" + sid + " ]";
    }
    
}
