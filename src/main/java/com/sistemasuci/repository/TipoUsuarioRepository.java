package com.sistemasuci.repository;

import com.sistemasuci.entity.Tipousuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoUsuarioRepository extends JpaRepository<Tipousuario, Integer> {

}
