package com.sistemasuci.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "oficial", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Oficial.findAll", query = "SELECT o FROM Oficial o")})
public class Oficial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "placa")
    private Integer placa;
    @Column(name = "tipo_oficial")
    private String tipoOficial;
    @Column(name = "cuerpo_oficial")
    private String cuerpoOficial;
    @Column(name = "a\u00f1os_servicio")
    private String añosServicio;
    @JoinColumn(name = "idpersonafk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonafk;

    public Oficial() {
    }

    public Oficial(Integer placa) {
        this.placa = placa;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public String getTipoOficial() {
        return tipoOficial;
    }

    public void setTipoOficial(String tipoOficial) {
        this.tipoOficial = tipoOficial;
    }

    public String getCuerpoOficial() {
        return cuerpoOficial;
    }

    public void setCuerpoOficial(String cuerpoOficial) {
        this.cuerpoOficial = cuerpoOficial;
    }

    public String getAñosServicio() {
        return añosServicio;
    }

    public void setAñosServicio(String añosServicio) {
        this.añosServicio = añosServicio;
    }

    public Persona getIdpersonafk() {
        return idpersonafk;
    }

    public void setIdpersonafk(Persona idpersonafk) {
        this.idpersonafk = idpersonafk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (placa != null ? placa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Oficial)) {
            return false;
        }
        Oficial other = (Oficial) object;
        if ((this.placa == null && other.placa != null) || (this.placa != null && !this.placa.equals(other.placa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Oficial[ placa=" + placa + " ]";
    }

}
