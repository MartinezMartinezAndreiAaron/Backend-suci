package com.sistemasuci.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "conductor", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Conductor.findAll", query = "SELECT c FROM Conductor c")})
public class Conductor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idconductor")
    private Integer idconductor;
    @Basic(optional = false)
    @Column(name = "no_licencia")
    private String noLicencia;
    @Basic(optional = false)
    @Column(name = "tipo_licencia")
    private String tipoLicencia;
    @Basic(optional = false)
    @Column(name = "vig_licencia")
    @Temporal(TemporalType.DATE)
    private Date vigLicencia;
    @Basic(optional = false)
    @Column(name = "tarjeta_circulacion")
    private String tarjetaCirculacion;
    @Basic(optional = false)
    @Column(name = "vig_tenencia")
    @Temporal(TemporalType.DATE)
    private Date vigTenencia;
    @Basic(optional = false)
    @Column(name = "numplacas")
    private String numplacas;
    @OneToMany(mappedBy = "idconductorfk")
    private List<Multa> multaList;
    @JoinColumn(name = "idpersonafk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonafk;

    public Conductor() {
    }

    public Conductor(Integer idconductor) {
        this.idconductor = idconductor;
    }

    public Conductor(Integer idconductor, String noLicencia, String tipoLicencia, Date vigLicencia, String tarjetaCirculacion, Date vigTenencia, String numplacas) {
        this.idconductor = idconductor;
        this.noLicencia = noLicencia;
        this.tipoLicencia = tipoLicencia;
        this.vigLicencia = vigLicencia;
        this.tarjetaCirculacion = tarjetaCirculacion;
        this.vigTenencia = vigTenencia;
        this.numplacas = numplacas;
    }

    public Integer getIdconductor() {
        return idconductor;
    }

    public void setIdconductor(Integer idconductor) {
        this.idconductor = idconductor;
    }

    public String getNoLicencia() {
        return noLicencia;
    }

    public void setNoLicencia(String noLicencia) {
        this.noLicencia = noLicencia;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public Date getVigLicencia() {
        return vigLicencia;
    }

    public void setVigLicencia(Date vigLicencia) {
        this.vigLicencia = vigLicencia;
    }

    public String getTarjetaCirculacion() {
        return tarjetaCirculacion;
    }

    public void setTarjetaCirculacion(String tarjetaCirculacion) {
        this.tarjetaCirculacion = tarjetaCirculacion;
    }

    public Date getVigTenencia() {
        return vigTenencia;
    }

    public void setVigTenencia(Date vigTenencia) {
        this.vigTenencia = vigTenencia;
    }

    public String getNumplacas() {
        return numplacas;
    }

    public void setNumplacas(String numplacas) {
        this.numplacas = numplacas;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idconductor != null ? idconductor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conductor)) {
            return false;
        }
        Conductor other = (Conductor) object;
        if ((this.idconductor == null && other.idconductor != null) || (this.idconductor != null && !this.idconductor.equals(other.idconductor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Conductor[ idconductor=" + idconductor + " ]";
    }

}
