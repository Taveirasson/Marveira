package com.banco.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banco.backend.model.ContaModel;
import com.banco.backend.service.ContaService;

@RestController
@RequestMapping("api/contas")
@CrossOrigin(origins = "http://localhost:3000")
public class ContaController {
    private final ContaService contaService;

    public ContaController(ContaService contaService){
        this.contaService = contaService;
    }

    @GetMapping
    public List<ContaModel> listarContas(){
        return contaService.listarContas();
    }

    @PostMapping
    public ContaModel criarConta(@RequestBody ContaModel conta){
        return contaService.salvarConta(conta);
    }
}
