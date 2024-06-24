/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.beneficiario;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Precision15-FirePro
 */
public class BeneficiarioController {
    private static final String FILE_NAME="beneficiario.txt";
    private static final String DATA_SOURCE_BENEFICIARIO=System.getProperty("user.dir")+ File.separator+FILE_NAME;
    private List<Beneficiario> beneficiarios=new ArrayList<>();

    public BeneficiarioController(){
        this.beneficiarios=lerBeneficiarios();
    }

    private void escreverBeneficiario(List<Beneficiario> beneficiarios){
        try{
            ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(DATA_SOURCE_BENEFICIARIO));
            obj.writeObject(beneficiarios);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private List<Beneficiario> lerBeneficiarios()
    {
        List<Beneficiario> beneficiarios=new ArrayList<>();

        try{
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(DATA_SOURCE_BENEFICIARIO));
            beneficiarios=(List<Beneficiario>) obj.readObject();

        }catch(FileNotFoundException ex){
            System.out.println("Arquivo de beneficiários não encontrado!Criando novo arquivo...");

        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return beneficiarios;
    }

    private void salvarBeneficiario(Beneficiario beneficiario) {
        this.beneficiarios.add(beneficiario);
        escreverBeneficiario(this.beneficiarios);
    }

    public void registrarBeneficiario(String designacao, String nif, String iban) {
        Beneficiario beneficiario = new Beneficiario(designacao, nif, iban);
        salvarBeneficiario(beneficiario);
        System.out.println("Beneficiário registrado com sucesso!");
    }

    public Beneficiario recuperarBeneficiarioPorId(int id) {
        for (Beneficiario beneficiario : beneficiarios) {
            if (beneficiario.getId() == id) {
                return beneficiario;
            }
        }
        return null;
    }
    public Beneficiario recuperarBeneficiarioPorNIF(String nif) {
        for (Beneficiario beneficiario : beneficiarios) {
            if (beneficiario.getNif().equals(nif)) {
                return beneficiario;
            }
        }
        return null;
    }

    public List<Beneficiario> listarTodosBeneficiarios() {
        return lerBeneficiarios();
    }
    
}
