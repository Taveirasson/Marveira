package com.banco.backend.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.banco.backend.repository.ClienteRepository;
import com.banco.backend.model.ClienteModel;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    public List<ClienteModel> listarClientes(){
        return clienteRepository.findAll();
    }

    public ClienteModel salvarCliente(ClienteModel cliente){
        return clienteRepository.save(cliente);
    }
}
