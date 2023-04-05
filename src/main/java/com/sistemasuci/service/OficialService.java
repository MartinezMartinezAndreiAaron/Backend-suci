package com.sistemasuci.service;

import com.sistemasuci.entity.Oficial;
import com.sistemasuci.repository.OficialRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OficialService {

    @Autowired
    private OficialRepository oficialRepository;

    public Oficial insertar(Oficial ofi) {
        return oficialRepository.save(ofi);
    }

    public Oficial actualizar(Oficial ofi) {
        return oficialRepository.save(ofi);
    }

    public List<Oficial> listar() {
        return oficialRepository.findAll();
    }

    public void eliminar(Oficial ofi) {
        oficialRepository.delete(ofi);
    }
}
