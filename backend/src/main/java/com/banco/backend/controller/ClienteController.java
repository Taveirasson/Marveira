package com.banco.backend.controller;

import com.banco.backend.model.ClienteModel;
import com.banco.backend.service.ClienteService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "http://localhost:3000")
public class ClienteController {
    private final ClienteService clienteService;
    
    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }
    
    @GetMapping
    public List<ClienteModel> listarClientes() {
        return clienteService.listarClientes();
    }

    @PostMapping
    public ClienteModel criarClienteModel(@RequestBody ClienteModel cliente){
        return clienteService.salvarCliente(cliente);
    }
}
