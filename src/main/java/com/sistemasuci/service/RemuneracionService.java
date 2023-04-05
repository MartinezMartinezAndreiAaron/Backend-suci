package com.sistemasuci.service;

import com.sistemasuci.entity.Remuneracion;
import com.sistemasuci.repository.RemuneracionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemuneracionService {

    @Autowired
    private RemuneracionRepository remuneracionRepository;

    public Remuneracion insertar(Remuneracion rem) {
        return remuneracionRepository.save(rem);
    }

    public Remuneracion actualizar(Remuneracion rem) {
        return remuneracionRepository.save(rem);
    }

    public List<Remuneracion> listar() {
        return remuneracionRepository.findAll();
    }

    public void eliminar(Remuneracion rem) {
        remuneracionRepository.delete(rem);
    }
}
