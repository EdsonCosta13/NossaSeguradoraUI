/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.auth;

import com.mycompany.nossasegurosui.usuario.Usuario;
import com.mycompany.nossasegurosui.usuario.UsuarioController;

/**
 *
 * @author Precision15-FirePro
 */
public class AuthController {
    private UsuarioController usuarioController;  
    private Usuario usuarioAutenticado;

    public AuthController() {
        this.usuarioController = new UsuarioController();
    }

    public Usuario authenticate(String username, String password) {
        for (Usuario usuario : usuarioController.listarTodosUsuarios()) {
            if (usuario.getEmail().equalsIgnoreCase(username) && usuario.getPassword().equals(password)) {
                this.usuarioAutenticado = usuario;
                return usuario;
            }
        }
        return null;
    }

    public String authenticateUser(String username, String password) {
        Usuario usuario = authenticate(username, password);
        if (usuario == null) {
            return "Credenciais inválidas. Tente novamente!";
        } else {
            return "Autenticação bem-sucedida! Bem-vindo(a), " + usuario.getNomeComepleto() + "!";
        }
    }

    public Usuario getAuthenticatedUser() {
        return this.usuarioAutenticado;
    }
}
