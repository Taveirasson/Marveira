package com.banco.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ContaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long numero;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private ClienteModel titular;
    @Enumerated(EnumType.STRING)
    private TipoConta tipo;
    private Double saldo;

    public  ContaModel(){

    }
    
    public ContaModel(Long numero, ClienteModel titular, TipoConta tipo, Double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Long getId(){
        return this.id;
    }

    public Long getNumero(){
        return this.numero;
    }

    public void setNumero(Long numero){
        this.numero = numero;
    }

    public ClienteModel getTitular(){
        return this.titular;
    }

    public void setTitular(ClienteModel titular){
        this.titular = titular;
    }

    public TipoConta getTipo(){
        return this.tipo;
    }

    public void setTipo(TipoConta tipo){
        this.tipo = tipo;
    }

    public Double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(Double saldo){
        this.saldo = saldo;
    }
}
