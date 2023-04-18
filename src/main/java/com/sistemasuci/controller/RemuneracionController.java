package com.sistemasuci.controller;

import com.sistemasuci.entity.Remuneracion;
import com.sistemasuci.service.RemuneracionService;
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
@RequestMapping("/remuneracion")
@CrossOrigin("*")
public class RemuneracionController {
    
    @Autowired
    private RemuneracionService remuneracionService;
    
    @GetMapping
    public List<Remuneracion> listar() {
        return remuneracionService.listar();
    }
    
    @PostMapping
    public Remuneracion insertar(@RequestBody Remuneracion rem) {
        return remuneracionService.insertar(rem);
    }
    
    @PutMapping
    public Remuneracion actualizar(@RequestBody Remuneracion rem) {
        return remuneracionService.actualizar(rem);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Remuneracion rem) {
        remuneracionService.eliminar(rem);
    }
}
