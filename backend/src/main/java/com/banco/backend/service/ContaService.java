package com.banco.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banco.backend.model.ContaModel;
import com.banco.backend.repository.ContaRepository;

@Service
public class ContaService {
    private final ContaRepository contaRepository;

    public ContaService(ContaRepository contaRepository){
        this.contaRepository = contaRepository;
    }

    public List<ContaModel> listarContas(){
        return contaRepository.findAll();
    }
    
    public ContaModel salvarConta( ContaModel conta){
        return contaRepository.save(conta);
    }
}
