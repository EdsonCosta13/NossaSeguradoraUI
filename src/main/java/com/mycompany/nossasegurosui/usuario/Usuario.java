/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.usuario;


import com.mycompany.nossasegurosui.generics.models.Genero;
import com.mycompany.nossasegurosui.generics.models.PessoaFisica;
import com.mycompany.nossasegurosui.localizacao.Localizacao;

import java.time.LocalDate;

/**
 *
 * @author Precision15-FirePro
 */
public class Usuario extends PessoaFisica {
    private String email;
    private String password;
    private TipoUsuario tipoUsuario;

    public Usuario(){}

    public Usuario(String nomeComepleto, String bilhete, LocalDate nascimento,
                   Genero sexo, Localizacao morada, String telefone, TipoUsuario tipoUsuario) {

        super(nomeComepleto, bilhete, nascimento, sexo, morada, telefone);
        this.email =gerarEmail();
        this.password =gerarSenha();
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nomeComepleto, String bilhete, LocalDate nascimento,
                   Genero sexo, Localizacao morada, String telefone) {

        super(nomeComepleto, bilhete, nascimento, sexo, morada, telefone);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String gerarSenha() {
//        Random random = new Random();
//        int numero = random.nextInt(9000) + 1000;
//        return String.valueOf(numero);

        return "123456";
    }

    public String gerarEmail() {
        return "cliente@gmail.com";
    }
}
