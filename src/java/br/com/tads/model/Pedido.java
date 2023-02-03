package br.com.tads.model;

import br.com.tads.model.status.EmAnalise;
import br.com.tads.model.status.Finalizado;
import br.com.tads.model.status.StatusPedido;
import java.io.Serializable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido implements Serializable{
    private int numero;
    private Orcamento orcamento;
    private StatusPedido statusPedido;
    private LocalDateTime dataCriacao;
    private List<Peca> pecas;


    public Pedido() {
        this.statusPedido = new EmAnalise();
        this.dataCriacao = LocalDateTime.now();
        this.pecas = new ArrayList();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Peca> getPecas() {
        return pecas;
    }

    public void adicionarPeca(Peca pecas) {
        this.pecas.add(pecas);
    }

    public void aprovar(){
        this.statusPedido.aprovar(this);
    }

    public void rejeitar(){
        this.statusPedido.rejeitar(this);
    }
    
    public void cancelar(){
        this.statusPedido.cancelar(this);
    }
    
    public void recolher(){
        this.statusPedido.recolher(this);
    }
    
    public void lavar(){
        this.statusPedido.lavar(this);
    }
    
    public void pagar(){
        this.statusPedido.pagar(this);
    }

    public void finalizar(){
        this.statusPedido.finalizar(this);
    }

    public void setStatusPedido(StatusPedido statusPedido){
        this.statusPedido = statusPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public boolean isFinalizado() {
        return statusPedido instanceof Finalizado;
    }
    

    @Override
    public String toString() {
        return "Pedido{" + "numero=" + numero + ", orcamento=" + orcamento + ", statusPedido=" + statusPedido + ", dataCriacao=" + dataCriacao + '}';
    }
    
    
}
