package com.sistemasuci.service;

import com.sistemasuci.entity.Usuarios;
import com.sistemasuci.repository.UsuariosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    public Usuarios insertar(Usuarios usu) {
        return usuariosRepository.save(usu);
    }

    public Usuarios actualizar(Usuarios usu) {
        return usuariosRepository.save(usu);
    }

    public List<Usuarios> listar() {
        return usuariosRepository.findAll();
    }

    public Optional<Usuarios> listarId(String id) {
        return usuariosRepository.findById(id);
    }

    public void eliminar(Usuarios usu) {
        usuariosRepository.delete(usu);
    }
}
