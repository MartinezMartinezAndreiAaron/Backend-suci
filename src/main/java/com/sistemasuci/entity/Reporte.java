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
@Table(name = "reporte", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Reporte.findAll", query = "SELECT r FROM Reporte r")})
public class Reporte implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idreporte")
    private Integer idreporte;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "evidencia")
    private String evidencia;
    @Basic(optional = false)
    @Column(name = "estatus")
    private String estatus;
    @OneToMany(mappedBy = "idreportefk")
    private List<Remuneracion> remuneracionList;
    @OneToMany(mappedBy = "reportefk")
    private List<Multa> multaList;
    @JoinColumn(name = "idreportadorfk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idreportadorfk;
    @JoinColumn(name = "tipousuariofk", referencedColumnName = "idtipousuario")
    @ManyToOne
    private Tipousuario tipousuariofk;

    public Reporte() {
    }

    public Reporte(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public Reporte(Integer idreporte, Date fecha, String direccion, String ubicacion, String descripcion, String evidencia, String estatus) {
        this.idreporte = idreporte;
        this.fecha = fecha;
        this.direccion = direccion;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.evidencia = evidencia;
        this.estatus = estatus;
    }

    public Integer getIdreporte() {
        return idreporte;
    }

    public void setIdreporte(Integer idreporte) {
        this.idreporte = idreporte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /*
    public List<Remuneracion> getRemuneracionList() {
        return remuneracionList;
    }

    public void setRemuneracionList(List<Remuneracion> remuneracionList) {
        this.remuneracionList = remuneracionList;
    }

    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }*/

    public Persona getIdreportadorfk() {
        return idreportadorfk;
    }

    public void setIdreportadorfk(Persona idreportadorfk) {
        this.idreportadorfk = idreportadorfk;
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
        hash += (idreporte != null ? idreporte.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reporte)) {
            return false;
        }
        Reporte other = (Reporte) object;
        if ((this.idreporte == null && other.idreporte != null) || (this.idreporte != null && !this.idreporte.equals(other.idreporte))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Reporte[ idreporte=" + idreporte + " ]";
    }

}
