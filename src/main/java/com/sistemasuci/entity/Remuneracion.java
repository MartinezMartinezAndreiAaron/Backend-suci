package com.sistemasuci.entity;

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

@Entity
@Table(name = "remuneracion", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Remuneracion.findAll", query = "SELECT r FROM Remuneracion r")})
public class Remuneracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idremuneracion")
    private Integer idremuneracion;
    @Basic(optional = false)
    @Column(name = "monto")
    private int monto;
    @Column(name = "estatus")
    private Boolean estatus;
    @JoinColumn(name = "idreportadorfk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idreportadorfk;
    @JoinColumn(name = "idreportefk", referencedColumnName = "idreporte")
    @ManyToOne
    private Reporte idreportefk;

    public Remuneracion() {
    }

    public Remuneracion(Integer idremuneracion) {
        this.idremuneracion = idremuneracion;
    }

    public Remuneracion(Integer idremuneracion, int monto) {
        this.idremuneracion = idremuneracion;
        this.monto = monto;
    }

    public Integer getIdremuneracion() {
        return idremuneracion;
    }

    public void setIdremuneracion(Integer idremuneracion) {
        this.idremuneracion = idremuneracion;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }

    public Persona getIdreportadorfk() {
        return idreportadorfk;
    }

    public void setIdreportadorfk(Persona idreportadorfk) {
        this.idreportadorfk = idreportadorfk;
    }

    public Reporte getIdreportefk() {
        return idreportefk;
    }

    public void setIdreportefk(Reporte idreportefk) {
        this.idreportefk = idreportefk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idremuneracion != null ? idremuneracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remuneracion)) {
            return false;
        }
        Remuneracion other = (Remuneracion) object;
        if ((this.idremuneracion == null && other.idremuneracion != null) || (this.idremuneracion != null && !this.idremuneracion.equals(other.idremuneracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Remuneracion[ idremuneracion=" + idremuneracion + " ]";
    }
    
}
