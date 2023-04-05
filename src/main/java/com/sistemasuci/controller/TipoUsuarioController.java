package com.sistemasuci.controller;

import com.sistemasuci.entity.Tipousuario;
import com.sistemasuci.service.TipoUsuarioService;
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
@RequestMapping("/tipousuario")
@CrossOrigin("*")
public class TipoUsuarioController {

    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping("/all")
    public List<Tipousuario> listar() {
        return tipoUsuarioService.listar();
    }

    @GetMapping("/find/{id}")
    public Optional<Tipousuario> find(@PathVariable Integer id) {
        return tipoUsuarioService.listarId(id);
    }

    @PostMapping("/guardar")
    public Tipousuario insertar(@RequestBody Tipousuario tipou) {
        return tipoUsuarioService.insertar(tipou);
    }

    @PutMapping("/actualizar")
    public Tipousuario actualizar(@RequestBody Tipousuario tipou) {
        return tipoUsuarioService.actualizar(tipou);
    }

    @DeleteMapping("/eliminar")
    public void eliminar(@RequestBody Tipousuario tipou) {
        tipoUsuarioService.eliminar(tipou);
    }
}
