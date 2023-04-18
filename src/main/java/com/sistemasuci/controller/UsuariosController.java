package com.sistemasuci.controller;

import com.sistemasuci.entity.Usuarios;
import com.sistemasuci.service.UsuariosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/all")
    public List<Usuarios> listar() {
        return usuariosService.listar();
    }

    @GetMapping("/find/{id}")
    public Optional<Usuarios> find(@PathVariable String id) {
        return usuariosService.listarId(id);
    }

    @PostMapping("/guardar")
    public Usuarios insertar(@RequestBody Usuarios usu) {
        return usuariosService.insertar(usu);
    }

    @PutMapping("/actualizar")
    public Usuarios actualizar(@RequestBody Usuarios usu) {
        return usuariosService.actualizar(usu);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Usuarios usu) {
        usuariosService.eliminar(usu);
    }
}
