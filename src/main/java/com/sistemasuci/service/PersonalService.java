package com.sistemasuci.service;

import com.sistemasuci.entity.Personal;
import com.sistemasuci.repository.PersonalRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalService {

    @Autowired
    private PersonalRepository personalRepository;

    public Personal insertar(Personal per) {
        return personalRepository.save(per);
    }

    public Personal actualizar(Personal per) {
        return personalRepository.save(per);
    }

    public List<Personal> listar() {
        return personalRepository.findAll();
    }

    public void eliminar(Personal per) {
        personalRepository.delete(per);
    }
}
