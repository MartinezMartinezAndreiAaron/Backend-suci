package com.sistemasuci.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {

    @GetMapping("/api/test/user")
    @PreAuthorize("hasTipousuario('USER') or hasTipousuario('ADMIN')")
    public String userAccess() {
        return ">>> Contenido de Usuarios!";
    }

    @GetMapping("/api/test/revisor")
    @PreAuthorize("hasTipousuario('REVISOR') or hasTipousuario('ADMIN')")
    public String revisorAccess() {
        return ">>> Contenido de Revisor!";
    }

    @GetMapping("/api/test/admin")
    @PreAuthorize("hasTipousuario('ADMIN')")
    public String adminAccess() {
        return ">>> Contenido de administrador!";
    }
}
