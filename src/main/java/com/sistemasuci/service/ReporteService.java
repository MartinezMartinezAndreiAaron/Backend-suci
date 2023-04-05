package com.sistemasuci.service;

import com.sistemasuci.entity.Reporte;
import com.sistemasuci.repository.ReporteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public Reporte insertar(Reporte rep) {
        return reporteRepository.save(rep);
    }

    public Reporte actualizar(Reporte rep) {
        return reporteRepository.save(rep);
    }

    public List<Reporte> listar() {
        return reporteRepository.findAll();
    }

    public void eliminar(Reporte rep) {
        reporteRepository.delete(rep);
    }
}
