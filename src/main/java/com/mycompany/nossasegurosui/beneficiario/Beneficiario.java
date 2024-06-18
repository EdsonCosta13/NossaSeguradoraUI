/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.beneficiario;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * @author Precision15-FirePro
 */
public class Beneficiario implements Serializable {

    private static final long serialVersionUID =1L;
    private static int contador = 0;
    private int id;
    private String designacao;
    private String nif;
    private String iban;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Beneficiario(){}
    public Beneficiario(String designacao, String nif, String iban) {
        setId();
        this.designacao = designacao;
        this.nif = nif;
        this.iban = iban;
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

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public static int gerarID() {
        synchronized (Beneficiario.class) {
            contador += 1;
            return contador;
        }
    }
    
}
