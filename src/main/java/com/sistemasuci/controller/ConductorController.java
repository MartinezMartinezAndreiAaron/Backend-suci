package com.sistemasuci.controller;

import com.sistemasuci.entity.Conductor;
import com.sistemasuci.service.ConductorService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/conductor")
@CrossOrigin("*")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping
    public List<Conductor> listar() {
        return conductorService.listar();
    }

    @PostMapping
    public Conductor insertar(@RequestBody Conductor con) {
        return conductorService.insertar(con);
    }

    @PutMapping
    public Conductor actualizar(@RequestBody Conductor con) {
        return conductorService.actualizar(con);
    }

    @DeleteMapping
    public void eliminar(@RequestBody Conductor con) {
        conductorService.eliminar(con);
    }
}
