/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.generics.models;

import com.mycompany.nossasegurosui.localizacao.Localizacao;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author Precision15-FirePro
 */
public class PessoaFisica implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    public int id;
    private String nomeComepleto;
    private String bilhete;
    private LocalDate nascimento;
    private Genero sexo;
    private Localizacao morada;
    private String telefone;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public PessoaFisica() {}

    public PessoaFisica(String nomeComepleto, String bilhete, LocalDate nascimento, Genero sexo, Localizacao morada, String telefone) {
        setId();
        this.nomeComepleto = nomeComepleto;
        this.bilhete = bilhete;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.morada = morada;
        this.telefone = telefone;
        setCreatedAt();
        setUpdatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = gerarID();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.createdAt=LocalDateTime.now();
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt=LocalDateTime.now();
    }

    public String getNomeComepleto() {
        return nomeComepleto;
    }

    public void setNomeComepleto(String nomeComepleto) {
        this.nomeComepleto = nomeComepleto;
    }

    public String getBilhete() {
        return bilhete;
    }

    public void setBilhete(String bilhete) {
        this.bilhete = bilhete;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Genero getSexo() {
        return sexo;
    }

    public void setSexo(Genero sexo) {
        this.sexo = sexo;
    }

    public Localizacao getMorada() {
        return morada;
    }

    public void setMorada(Localizacao morada) {
        this.morada = morada;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public static int gerarID() {
        synchronized (PessoaFisica.class) {
            contador += 1;
            return contador;
        }
    }
}
