package com.sistemasuci.controller;

import com.sistemasuci.entity.Usuarios;
import com.sistemasuci.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuarios> listar() {
        return usuariosService.listar();
    }

    @PostMapping
    public Usuarios insertar(@RequestBody Usuarios usu) {
        return usuariosService.insertar(usu);
    }

    @PutMapping
    public Usuarios actualizar(@RequestBody Usuarios usu) {
        return usuariosService.actualizar(usu);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Usuarios usu) {
        usuariosService.eliminar(usu);
    }
}
