package com.sistemasuci.controller;

import com.sistemasuci.entity.Oficial;
import com.sistemasuci.service.OficialService;
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
@RequestMapping("/oficial")
@CrossOrigin("*")
public class OficialController {

    @Autowired
    private OficialService oficialService;
    
    @GetMapping
    public List<Oficial> listar() {
        return oficialService.listar();
    }
    
    @PostMapping
    public Oficial insertar(@RequestBody Oficial ofi) {
        return oficialService.insertar(ofi);
    }
    
    @PutMapping
    public Oficial actualizar(@RequestBody Oficial ofi) {
        return oficialService.actualizar(ofi);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Oficial ofi) {
        oficialService.eliminar(ofi);
    }
}
