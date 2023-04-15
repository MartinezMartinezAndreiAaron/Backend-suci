package com.sistemasuci.request;

import com.sistemasuci.entity.Tipousuario;
import java.util.Set;

public class SingUpForm {

    private String username;

    private String password;

    private Set<String> tipousuario;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(Set<String> tipousuario) {
        this.tipousuario = tipousuario;
    }

}
