/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.cliente;

import com.mycompany.nossasegurosui.generics.models.Genero;
import com.mycompany.nossasegurosui.generics.models.PessoaFisica;
import com.mycompany.nossasegurosui.localizacao.Localizacao;

import java.io.Serializable;
import java.time.LocalDate;

public class Cliente extends PessoaFisica implements Serializable {

    private static final long serialVersionUID =1L;
    private String referencia;

    public Cliente(){}

    public Cliente(String nomeComepleto, String bilhete, LocalDate nascimento,
                   Genero sexo, Localizacao morada, String telefone,
                   String referencia) {

        super(nomeComepleto, bilhete, nascimento, sexo, morada, telefone);
        this.referencia = referencia;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
