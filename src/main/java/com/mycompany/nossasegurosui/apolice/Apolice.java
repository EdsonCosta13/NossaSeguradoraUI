/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nossasegurosui.apolice;

import com.mycompany.nossasegurosui.beneficiario.Beneficiario;
import com.mycompany.nossasegurosui.cliente.Cliente;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Apolice implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 0;
    private int id;
    private Cliente cliente;
    private String referencia;
    private TipoSeguro tipoSeguro;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Double premioSeguro;
    private FequenciaPagamento frequenciaPagamento;
    private List<Double> pagamentosPremio;
    private Beneficiario beneficiario;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Apolice(Cliente cliente,TipoSeguro tipoSeguro, LocalDate dataInicio, LocalDate dataTermino,
                   Double premioSeguro, FequenciaPagamento frequenciaPagamento,
                   List<Double> pagamentosPremio, Beneficiario beneficiario) {

        setId();
        this.cliente=cliente;
        this.tipoSeguro = tipoSeguro;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.premioSeguro = premioSeguro;
        this.frequenciaPagamento = frequenciaPagamento;
        this.pagamentosPremio = pagamentosPremio;
        this.beneficiario = beneficiario;
        this.referencia="AP003";

        setCreatedAt();
        setUpdatedAt();
    }

    public int getId() {
        return id;
    }

    public void setId() {
        this.id = gerarID();
    }



    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public TipoSeguro getTipoSeguro() {
        return tipoSeguro;
    }

    public void setTipoSeguro(TipoSeguro tipoSeguro) {
        this.tipoSeguro = tipoSeguro;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Double getPremioSeguro() {
        return premioSeguro;
    }

    public void setPremioSeguro(Double premioSeguro) {
        this.premioSeguro = premioSeguro;
    }

    public FequenciaPagamento getFrequenciaPagamento() {
        return frequenciaPagamento;
    }

    public void setFrequenciaPagamento(FequenciaPagamento frequenciaPagamento) {
        this.frequenciaPagamento = frequenciaPagamento;
    }

    public List<Double> getPagamentosPremio() {
        return pagamentosPremio;
    }

    public void setPagamentosPremio(List<Double> pagamentosPremio) {
        this.pagamentosPremio = pagamentosPremio;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
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

    public static int gerarID() {
        synchronized (Apolice.class) {
            contador += 1;
            return contador;
        }
    }

    public double getTotalPagamentosFeitos(){
        return this.pagamentosPremio.stream().mapToDouble(Double::doubleValue).sum();
    }

}
