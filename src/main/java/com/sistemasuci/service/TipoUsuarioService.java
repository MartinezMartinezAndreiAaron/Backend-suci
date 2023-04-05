package com.sistemasuci.service;

import com.sistemasuci.entity.Tipousuario;
import com.sistemasuci.repository.TipoUsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUsuarioService {

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Tipousuario insertar(Tipousuario tipou) {
        return tipoUsuarioRepository.save(tipou);
    }

    public Tipousuario actualizar(Tipousuario tipou) {
        return tipoUsuarioRepository.save(tipou);
    }

    public List<Tipousuario> listar() {
        return tipoUsuarioRepository.findAll();
    }
    
    public Optional<Tipousuario> listarId(int id){
        return tipoUsuarioRepository.findById(id);
    }

    public void eliminar(Tipousuario tipou) {
        tipoUsuarioRepository.delete(tipou);
    }
}
