package com.sistemasuci.repository;

import com.sistemasuci.entity.Usuarios;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {

    Optional<Usuarios> findByUserName(String userName);

    Boolean existsByUserName(String userName);

}
