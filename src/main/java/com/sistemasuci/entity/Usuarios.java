package com.sistemasuci.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios", catalog = "SuCi", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @Column(name = "contrase\u00f1a")
    private String contraseña;
    @JoinColumn(name = "idpersonafk", referencedColumnName = "idpersona")
    @ManyToOne
    private Persona idpersonafk;
    @JoinColumn(name = "tipousuariofk", referencedColumnName = "idtipousuario")
    @ManyToMany
    //private Tipousuario tipousuariofk;

    private Set<Tipousuario> tipousuarios = new HashSet<>();

    public Usuarios() {
    }

    public Usuarios(String usuario) {
        this.usuario = usuario;
    }

    public Usuarios(String usuario, String contraseña) {
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Persona getIdpersonafk() {
        return idpersonafk;
    }

    public void setIdpersonafk(Persona idpersonafk) {
        this.idpersonafk = idpersonafk;
    }

    /**
     * public Tipousuario getTipousuariofk() { return tipousuariofk; }
     *
     * public void setTipousuariofk(Tipousuario tipousuariofk) {
     * this.tipousuariofk = tipousuariofk; }
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuario != null ? usuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuario == null && other.usuario != null) || (this.usuario != null && !this.usuario.equals(other.usuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemasuci.entity.Usuarios[ usuario=" + usuario + " ]";
    }

    public Set<Tipousuario> getTipousuarios() {
        return tipousuarios;
    }

    public void setTipousuarios(Set<Tipousuario> tipousuarios) {
        this.tipousuarios = tipousuarios;
    }

}
