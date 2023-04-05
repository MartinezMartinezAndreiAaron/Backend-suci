package com.sistemasuci.repository;

import com.sistemasuci.entity.Remuneracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemuneracionRepository extends JpaRepository<Remuneracion, Integer> {

}
