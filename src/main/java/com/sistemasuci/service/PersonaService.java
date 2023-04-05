package com.sistemasuci.service;

import com.sistemasuci.entity.Persona;
import com.sistemasuci.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public Persona insertar(Persona per) {
        return personaRepository.save(per);
    }

    public Persona actualizar(Persona per) {
        return personaRepository.save(per);
    }

    public List<Persona> listar() {
        return personaRepository.findAll();
    }

    public Optional<Persona> listarId(int id) {
        return personaRepository.findById(id);
    }

    public void eliminar(Persona per) {
        personaRepository.delete(per);
    }
}
