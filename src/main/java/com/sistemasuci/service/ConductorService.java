package com.sistemasuci.service;

import com.sistemasuci.entity.Conductor;
import com.sistemasuci.repository.ConductorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public Conductor insertar(Conductor con) {
        return conductorRepository.save(con);
    }

    public Conductor actualizar(Conductor con) {
        return conductorRepository.save(con);
    }

    public List<Conductor> listar() {
        return conductorRepository.findAll();
    }

    public void eliminar(Conductor con) {
        conductorRepository.delete(con);
    }
}
