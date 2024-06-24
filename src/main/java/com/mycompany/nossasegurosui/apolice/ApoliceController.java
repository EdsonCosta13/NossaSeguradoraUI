/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.apolice;

import com.mycompany.nossasegurosui.beneficiario.Beneficiario;
import com.mycompany.nossasegurosui.cliente.Cliente;
import com.mycompany.nossasegurosui.cliente.ClienteController;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Precision15-FirePro
 */
public class ApoliceController {

    private static final String FILE_NAME="apolice.txt";
    private static final String DATA_SOURCE_APOLICE=System.getProperty("user.dir")+ File.separator+FILE_NAME;
    private List<Apolice> apolices=new ArrayList<>();
    public ClienteController clienteController=new ClienteController();

    public ApoliceController(){
        this.apolices=lerApolices();
    }

    private void escreverApolice(List<Apolice> apolices){
        try{
            ObjectOutputStream obj=new ObjectOutputStream(new FileOutputStream(DATA_SOURCE_APOLICE));
            obj.writeObject(apolices);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    private List<Apolice> lerApolices()
    {
        List<Apolice> apolices=new ArrayList<>();

        try{
            ObjectInputStream obj=new ObjectInputStream(new FileInputStream(DATA_SOURCE_APOLICE));
            apolices=(List<Apolice>) obj.readObject();

        }catch(FileNotFoundException ex){
            System.out.println("Arquivo de apolices não encontrado!Criando novo arquivo...");

        }catch(IOException | ClassNotFoundException ex){
            ex.printStackTrace();
        }

        return apolices;
    }

    private void salvarApolice(Apolice apolice) {
        this.apolices.add(apolice);
        escreverApolice(this.apolices);
    }

    public void registarApolice(Cliente clienteId, TipoSeguro tipoSeguro, LocalDate dataInicio,
                                LocalDate dataTermino, Double premioSeguro,
                                FequenciaPagamento frequenciaPagamento,
                                List<Double> pagamentosPremio, Beneficiario beneficiario)
    {
        Cliente cliente=clienteController.recuperarClientePorId(clienteId.getId());

        if(cliente!=null)
        {
            Apolice apolice=new Apolice(clienteId,tipoSeguro,dataInicio,dataTermino,premioSeguro,frequenciaPagamento,pagamentosPremio,beneficiario);
            salvarApolice(apolice);
            System.out.println("Apolice registrada com sucesso!");
        }else{
            System.out.println("Cliente com ID " + clienteId + " não encontrado.Não é possível registar a apolice!");
        }
    }

    public List<Apolice> listarTodasApolices() {
//        return lerApolices();
        for (Apolice apolice:lerApolices())
        {
            apolices.add(apolice);
        }

        return apolices;
    }

    public Apolice recuperarApolicePorRef(String ref) {
        for (Apolice apolice : apolices) {
            if (apolice.getReferencia().equals(ref)) {
                return apolice;
            }
        }
        return null;
    }

    public void pagarPremioApolice(String apoliceRef,double pagamentoPremio)
    {
        var apolice=this.recuperarApolicePorRef(apoliceRef);

        if(apolice!=null ){

            double totPagamentosFeitos=apolice.getTotalPagamentosFeitos();
            double totPagamentoRestante=apolice.getPremioSeguro()-totPagamentosFeitos;

//            // Debug messages
//            System.out.println("Debug: Total pagamentos feitos: " + totPagamentosFeitos);
//            System.out.println("Debug: Premio seguro: " + apolice.getPremioSeguro());
//            System.out.println("Debug: Total restante: " + totPagamentoRestante);
//            System.out.println("Debug: Pagamento Premio: " + pagamentoPremio);

            if (pagamentoPremio > 0.0 && pagamentoPremio <= totPagamentoRestante) {
                apolice.getPagamentosPremio().add(pagamentoPremio);
                apolice.setUpdatedAt();
                escreverApolice(apolices);
                System.out.println("Success: " + pagamentoPremio + " Kzs pago para a Apólice " + apoliceRef);
            } else {
                System.out.println("Error: O pagamento excede o valor restante da apólice. Valor restante: " + totPagamentoRestante);
            }

        }else{
            System.out.println("Error:Não foi possível concluir a operação porque a Apólice "+apoliceRef+" não foi encontrada!");
        }
    }
    
}
