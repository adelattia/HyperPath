package org.hyperpath.persistence.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


@Entity
@Table(name = "phones", catalog = "hyperPath", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"number"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Phones.findAll"     , query = "SELECT p FROM Phones p"),
    @NamedQuery(name = "Phones.findById"    , query = "SELECT p FROM Phones p WHERE p.id = :id"),
    @NamedQuery(name = "Phones.findByNumber", query = "SELECT p FROM Phones p WHERE p.number = :number")})
public class Phones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "number", nullable = false, length = 45)
    private String number;
    @ManyToMany(mappedBy = "phonesList")
    private List<Entities> entitiesList;

    public Phones() {
    }

    public Phones(Integer id) {
        this.id = id;
    }

    public Phones(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @XmlTransient
    public List<Entities> getEntitiesList() {
        return entitiesList;
    }

    public void setEntitiesList(List<Entities> entitiesList) {
        this.entitiesList = entitiesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Phones)) {
            return false;
        }
        Phones other = (Phones) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.hyperpath.persistence.entities.Phones[ id=" + id + " ]";
    }
    
}
