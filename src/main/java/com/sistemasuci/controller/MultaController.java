package com.sistemasuci.controller;

import com.sistemasuci.entity.Multa;
import com.sistemasuci.service.MultaService;
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
@RequestMapping("/multa")
@CrossOrigin("*")
public class MultaController {
    
    @Autowired
    private MultaService multaService;
    
    @GetMapping
    public List<Multa> listar() {
        return multaService.listar();
    }
    
    @PostMapping
    public Multa insertar(@RequestBody Multa mul) {
        return multaService.insertar(mul);
    }
    
    @PutMapping
    public Multa actualizar(@RequestBody Multa mul) {
        return multaService.actualizar(mul);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Multa mul) {
        multaService.eliminar(mul);
    }
}
