package com.sistemasuci.entity;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "personal", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Personal.findAll", query = "SELECT p FROM Personal p")})
public class Personal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonal")
    private Integer idpersonal;
    @OneToMany(mappedBy = "personalfk")
    private List<Multa> multaList;
    @JoinColumn(name = "idpersonafk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonafk;
    @JoinColumn(name = "tipousuariofk", referencedColumnName = "idtipousuario")
    @ManyToOne
    private Tipousuario tipousuariofk;

    public Personal() {
    }

    public Personal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    public Integer getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(Integer idpersonal) {
        this.idpersonal = idpersonal;
    }

    /*
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }*/

    public Persona getIdpersonafk() {
        return idpersonafk;
    }

    public void setIdpersonafk(Persona idpersonafk) {
        this.idpersonafk = idpersonafk;
    }

    public Tipousuario getTipousuariofk() {
        return tipousuariofk;
    }

    public void setTipousuariofk(Tipousuario tipousuariofk) {
        this.tipousuariofk = tipousuariofk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonal != null ? idpersonal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personal)) {
            return false;
        }
        Personal other = (Personal) object;
        if ((this.idpersonal == null && other.idpersonal != null) || (this.idpersonal != null && !this.idpersonal.equals(other.idpersonal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Personal[ idpersonal=" + idpersonal + " ]";
    }

}
