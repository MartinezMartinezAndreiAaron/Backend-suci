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
@Table(name = "persona", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersona")
    private Integer idpersona;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellidop")
    private String apellidop;
    @Basic(optional = false)
    @Column(name = "apellidom")
    private String apellidom;
    @Basic(optional = false)
    @Column(name = "edad")
    private int edad;
    @Basic(optional = false)
    @Column(name = "calle")
    private String calle;
    @Basic(optional = false)
    @Column(name = "colonia")
    private String colonia;
    @Basic(optional = false)
    @Column(name = "municipio")
    private String municipio;
    @Basic(optional = false)
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @Column(name = "correo")
    private String correo;
    @Column(name = "numcuenta")
    private String numcuenta;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "numeroSuspenciones")
    private Integer numeroSuspenciones;
    @OneToMany(mappedBy = "idreportadorfk")
    private List<Remuneracion> remuneracionList;
    @JoinColumn(name = "tipousuariofk", referencedColumnName = "idtipousuario")
    @ManyToOne
    private Tipousuario tipousuariofk;
    @OneToMany(mappedBy = "idreportadorfk")
    private List<Multa> multaList;
    @OneToMany(mappedBy = "idpersonafk")
    private List<Personal> personalList;
    @OneToMany(mappedBy = "idpersonafk")
    private List<Oficial> oficialList;
    @OneToMany(mappedBy = "idpersonafk")
    private List<Usuarios> usuariosList;
    @OneToMany(mappedBy = "idpersonafk")
    private List<Conductor> conductorList;
    @OneToMany(mappedBy = "idreportadorfk")
    private List<Reporte> reporteList;

    public Persona() {
    }

    public Persona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public Persona(Integer idpersona, String nombre, String apellidop, String apellidom, int edad, String calle, String colonia, String municipio, int telefono, String correo) {
        this.idpersona = idpersona;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.edad = edad;
        this.calle = calle;
        this.colonia = colonia;
        this.municipio = municipio;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Integer getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(Integer idpersona) {
        this.idpersona = idpersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNumcuenta() {
        return numcuenta;
    }

    public void setNumcuenta(String numcuenta) {
        this.numcuenta = numcuenta;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Integer getNumeroSuspenciones() {
        return numeroSuspenciones;
    }

    public void setNumeroSuspenciones(Integer numeroSuspenciones) {
        this.numeroSuspenciones = numeroSuspenciones;
    }

    /*
    public List<Remuneracion> getRemuneracionList() {
        return remuneracionList;
    }

    public void setRemuneracionList(List<Remuneracion> remuneracionList) {
        this.remuneracionList = remuneracionList;
    }*/

    public Tipousuario getTipousuariofk() {
        return tipousuariofk;
    }

    public void setTipousuariofk(Tipousuario tipousuariofk) {
        this.tipousuariofk = tipousuariofk;
    }

    /*
    public List<Multa> getMultaList() {
        return multaList;
    }

    public void setMultaList(List<Multa> multaList) {
        this.multaList = multaList;
    }

    public List<Personal> getPersonalList() {
        return personalList;
    }

    public void setPersonalList(List<Personal> personalList) {
        this.personalList = personalList;
    }

    public List<Oficial> getOficialList() {
        return oficialList;
    }

    public void setOficialList(List<Oficial> oficialList) {
        this.oficialList = oficialList;
    }

    public List<Usuarios> getUsuariosList() {
        return usuariosList;
    }

    public void setUsuariosList(List<Usuarios> usuariosList) {
        this.usuariosList = usuariosList;
    }

    public List<Conductor> getConductorList() {
        return conductorList;
    }

    public void setConductorList(List<Conductor> conductorList) {
        this.conductorList = conductorList;
    }

    public List<Reporte> getReporteList() {
        return reporteList;
    }

    public void setReporteList(List<Reporte> reporteList) {
        this.reporteList = reporteList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersona != null ? idpersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idpersona == null && other.idpersona != null) || (this.idpersona != null && !this.idpersona.equals(other.idpersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Persona[ idpersona=" + idpersona + " ]";
    }

}
