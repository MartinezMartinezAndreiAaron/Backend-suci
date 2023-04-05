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
@Table(name = "multa", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Multa.findAll", query = "SELECT m FROM Multa m")})
public class Multa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmulta")
    private Integer idmulta;
    @Basic(optional = false)
    @Column(name = "infraccion")
    private String infraccion;
    @Basic(optional = false)
    @Column(name = "razon")
    private String razon;
    @Basic(optional = false)
    @Column(name = "monto")
    private int monto;
    @Column(name = "estatus")
    private Boolean estatus;
    @JoinColumn(name = "idconductorfk", referencedColumnName = "idconductor")
    @ManyToOne
    private Conductor idconductorfk;
    @JoinColumn(name = "idreportadorfk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idreportadorfk;
    @JoinColumn(name = "personalfk", referencedColumnName = "idpersonal")
    @ManyToOne
    private Personal personalfk;
    @JoinColumn(name = "reportefk", referencedColumnName = "idreporte")
    @ManyToOne
    private Reporte reportefk;

    public Multa() {
    }

    public Multa(Integer idmulta) {
        this.idmulta = idmulta;
    }

    public Multa(Integer idmulta, String infraccion, String razon, int monto) {
        this.idmulta = idmulta;
        this.infraccion = infraccion;
        this.razon = razon;
        this.monto = monto;
    }

    public Integer getIdmulta() {
        return idmulta;
    }

    public void setIdmulta(Integer idmulta) {
        this.idmulta = idmulta;
    }

    public String getInfraccion() {
        return infraccion;
    }

    public void setInfraccion(String infraccion) {
        this.infraccion = infraccion;
    }

    public String getRazon() {
        return razon;
    }

    public void setRazon(String razon) {
        this.razon = razon;
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

    public Conductor getIdconductorfk() {
        return idconductorfk;
    }

    public void setIdconductorfk(Conductor idconductorfk) {
        this.idconductorfk = idconductorfk;
    }

    public Persona getIdreportadorfk() {
        return idreportadorfk;
    }

    public void setIdreportadorfk(Persona idreportadorfk) {
        this.idreportadorfk = idreportadorfk;
    }

    public Personal getPersonalfk() {
        return personalfk;
    }

    public void setPersonalfk(Personal personalfk) {
        this.personalfk = personalfk;
    }

    public Reporte getReportefk() {
        return reportefk;
    }

    public void setReportefk(Reporte reportefk) {
        this.reportefk = reportefk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmulta != null ? idmulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Multa)) {
            return false;
        }
        Multa other = (Multa) object;
        if ((this.idmulta == null && other.idmulta != null) || (this.idmulta != null && !this.idmulta.equals(other.idmulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Multa[ idmulta=" + idmulta + " ]";
    }

}
