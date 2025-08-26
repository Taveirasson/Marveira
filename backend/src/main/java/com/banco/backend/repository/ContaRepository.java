package com.banco.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.banco.backend.model.ContaModel;

@Repository
public interface ContaRepository extends JpaRepository<ContaModel, Long>{
    
}
