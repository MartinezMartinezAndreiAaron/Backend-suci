package com.sistemasuci.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @GetMapping("/all")
    public String getAllAccess() {
        return "Contenido Publico";
    }

    @GetMapping("/user")
    @PreAuthorize("hasTipousuario('USER') or hasTipousuario('REVISOR') or hasTipousuario('ADMIN')")
    public String userAccess() {
        return ">>> Contenido de Usuarios!";
    }

    @GetMapping("/revisor")
    @PreAuthorize("hasTipousuario('REVISOR')")
    public String revisorAccess() {
        return ">>> Contenido de Revisor!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasTipousuario('ADMIN')")
    public String adminAccess() {
        return ">>> Contenido de administrador!";
    }
}
