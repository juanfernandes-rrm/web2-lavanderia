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
    private List<Roupa> roupas = new ArrayList<>();


    public Pedido() {
        this.statusPedido = new EmAnalise();
        this.dataCriacao = LocalDateTime.now();
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

    public List<Roupa> getRoupas() {
        return roupas;
    }

    public void adicionarRoupa(Roupa roupa) {
        this.roupas.add(roupa);
    }

    public void aprovar(){
        this.statusPedido.aprovar(this);
    }

    public void reprovar(){
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
        return "Pedido{" + "numero=" + numero + ", orcamento=" + orcamento + ", statusPedido=" + statusPedido + ", dataCriacao=" + dataCriacao + ", roupas=" + roupas.toString() + '}';
    }
    
    
}
