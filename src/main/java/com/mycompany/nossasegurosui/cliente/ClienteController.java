/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.cliente;

import com.mycompany.nossasegurosui.generics.models.Genero;
import com.mycompany.nossasegurosui.localizacao.Localizacao;
import com.mycompany.nossasegurosui.usuario.TipoUsuario;
import com.mycompany.nossasegurosui.usuario.UsuarioController;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Precision15-FirePro
 */
public class ClienteController {

    private static final String FILE_NAME="cliente.txt";
    private static final String DATA_SOURCE_CLIENTE=System.getProperty("user.dir")+ File.separator+FILE_NAME;
    private List<Cliente> clientes=new ArrayList<>();
    private final UsuarioController usuarioController=new UsuarioController();

    public ClienteController(){
        this.clientes=lerClientes();
    }

    private void escreverCliente(List<Cliente> clientes){
        try{
            ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(DATA_SOURCE_CLIENTE));
            obj.writeObject(clientes);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private List<Cliente> lerClientes()
    {
        List<Cliente> clientes=new ArrayList<>();

        try{
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(DATA_SOURCE_CLIENTE));
            clientes=(List<Cliente>) obj.readObject();

        }catch(FileNotFoundException ex){
            System.out.println("Arquivo de clientes não encontrado!Criando novo arquivo...");

        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return clientes;
    }

    private void salvarCliente(Cliente cliente) {
        this.clientes.add(cliente);
        escreverCliente(this.clientes);
    }

    public void registrarCliente(String nomeCompleto, String bilhete, LocalDate nascimento,
                                 Genero sexo, Localizacao morada, String telefone, String referencia) {
        Cliente cliente = new Cliente(nomeCompleto, bilhete, nascimento, sexo, morada, telefone, referencia);
        salvarCliente(cliente);

        this.usuarioController.registrarUsuario(nomeCompleto, bilhete, nascimento, sexo, morada, telefone, TipoUsuario.CLIENTE);

        System.out.println("Cliente registrado com sucesso!");
    }

    public Cliente recuperarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente recuperarClientePorBI(String bi) {
        for (Cliente cliente : clientes) {
            if (cliente.getBilhete().equals(bi)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente recuperarClientePorRef(String ref) {
        for (Cliente cliente : clientes) {
            if (cliente.getReferencia().equals(ref)) {
                return cliente;
            }
        }
        return null;
    }
    public List<Cliente> listarTodosClientes() {
        for (Cliente cliente:lerClientes()){
            clientes.add(cliente);
        }

        return clientes;
    }

    public boolean validarCliente(int id)
    {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
}
