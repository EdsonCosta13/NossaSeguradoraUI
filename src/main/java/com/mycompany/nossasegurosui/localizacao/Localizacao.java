/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.localizacao;


import java.io.Serializable;
import java.time.LocalDateTime;

public class Localizacao implements Serializable {

    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private int id;
    private String provincia;
    private String municipio;
    private String bairro;
    private String descricao;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Localizacao(String provincia, String municipio, String bairro, String descricao) {
        setId();
        this.provincia = provincia;
        this.municipio = municipio;
        this.bairro = bairro;
        this.descricao = descricao;
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

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static int gerarID() {
        synchronized (Localizacao.class) {
            contador += 1;
            return contador;
        }
    }
    
}
