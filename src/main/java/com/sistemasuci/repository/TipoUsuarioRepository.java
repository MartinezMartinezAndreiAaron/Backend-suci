package com.sistemasuci.repository;

import com.sistemasuci.entity.TipoUsuarioNombre;
import com.sistemasuci.entity.Tipousuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipousuario, Integer> {

    Optional<Tipousuario> findByName(TipoUsuarioNombre tipoUsuarioNombre);
}
