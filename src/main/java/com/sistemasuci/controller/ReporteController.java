package com.sistemasuci.controller;

import com.sistemasuci.entity.Reporte;
import com.sistemasuci.service.ReporteService;
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
@RequestMapping("/reporte")
@CrossOrigin("*")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;
    
    @GetMapping
    public List<Reporte> listar() {
        return reporteService.listar();
    }
    
    @PostMapping
    public Reporte intertar(@RequestBody Reporte rep) {
        return reporteService.insertar(rep);
    }
    
    @PutMapping
    public Reporte actualizar(@RequestBody Reporte rep) {
        return reporteService.actualizar(rep);
    }
    
    @DeleteMapping
    public void eliminar(@RequestBody Reporte rep) {
        reporteService.eliminar(rep);
    }
}
