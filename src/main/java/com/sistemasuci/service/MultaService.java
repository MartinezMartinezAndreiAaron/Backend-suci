package com.sistemasuci.service;

import com.sistemasuci.entity.Multa;
import com.sistemasuci.repository.MultaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MultaService {

    @Autowired
    private MultaRepository multaRepository;
    
    public Multa insertar(Multa mul) {
        return multaRepository.save(mul);
    }

    public Multa actualizar(Multa mul) {
        return multaRepository.save(mul);
    }

    public List<Multa> listar() {
        return multaRepository.findAll();
    }

    public void eliminar(Multa mul) {
        multaRepository.delete(mul);
    }
}
