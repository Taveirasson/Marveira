package com.banco.backend.repository;

import org.springframework.stereotype.Repository;
import com.banco.backend.model.ClienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteModel, Long>{
    
}
