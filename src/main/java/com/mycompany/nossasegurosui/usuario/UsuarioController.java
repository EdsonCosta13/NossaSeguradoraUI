/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.usuario;

import com.mycompany.nossasegurosui.generics.models.Genero;
import com.mycompany.nossasegurosui.localizacao.Localizacao;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Precision15-FirePro
 */
public class UsuarioController {

    private static final String FILE_NAME="usuario.txt";
    private static final String DATA_SOURCE_USUARIO=System.getProperty("user.dir")+ File.separator+FILE_NAME;
    private List<Usuario> usuarios=new ArrayList<>();

    public UsuarioController(){
        this.usuarios=lerUsuarios();
    }


    private void escreverUsuario(List<Usuario> usuarios) {
        try {
            ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(DATA_SOURCE_USUARIO));
            obj.writeObject(usuarios);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private List<Usuario> lerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try {
            ObjectInputStream obj = new ObjectInputStream(new FileInputStream(DATA_SOURCE_USUARIO));
            usuarios = (List<Usuario>) obj.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo de usuários não encontrado! Criando novo arquivo...");
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }

    private void salvarUsuario(Usuario usuario) {
        this.usuarios.add(usuario);
        escreverUsuario(this.usuarios);
    }

    public void registrarUsuario(String nomeComepleto, String bilhete, LocalDate nascimento,
                                 Genero sexo, Localizacao morada, String telefone, TipoUsuario tipoUsuario) {

        Usuario usuario=new Usuario(nomeComepleto,bilhete,nascimento,sexo,morada,telefone,tipoUsuario);

        salvarUsuario(usuario);
        System.out.println("Usuário registrado com sucesso!");
    }

    public Usuario recuperarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId()==id) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario recuperarUsuarioPorUsername(String name) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(name)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> listarTodosUsuarios() {
//        for (Usuario usuario:lerUsuarios()){
//            usuarios.add(usuario);
//        }

        return usuarios;
    }

    public List<Usuario> listarUsuariosPorTipo(TipoUsuario tipoUsuario) {
        List<Usuario> usuariosPorTipo = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoUsuario() == tipoUsuario) {
                usuariosPorTipo.add(usuario);
            }
        }
        return usuariosPorTipo;
    }

    public List<Usuario> listarUsuariosBrokers() {
        List<Usuario> brokers = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoUsuario() == TipoUsuario.BROKER) {
                brokers.add(usuario);
            }
        }
        return brokers;
    }

    public List<Usuario> listarUsuariosAdm() {
        List<Usuario> admins = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getTipoUsuario() == TipoUsuario.ADMIN) {
                admins.add(usuario);
            }
        }
        return admins;
    }
    
}
