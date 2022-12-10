/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model;

import java.util.ArrayList;

/**
 *
 * @author Felipe
 */
public class PedidoTeste {
    private int numero;
    private double orcamento;
    private String statusPedido;
    private String dataCriacao;
    private String roupas;

    public PedidoTeste() {
    }

    public PedidoTeste(int numero, double orcamento, String statusPedido, String dataCriacao, String roupas) {
        this.numero = numero;
        this.orcamento = orcamento;
        this.statusPedido = statusPedido;
        this.dataCriacao = dataCriacao;
        this.roupas = roupas;
    }
    
        public ArrayList PedidosLista(){
        ArrayList<PedidoTeste> listaPedidos = new ArrayList<PedidoTeste>();
        PedidoTeste p1 = new PedidoTeste(1,100,"EM ABERTO","01/01/2023","Camisa");
        PedidoTeste p2 = new PedidoTeste(2,200,"RECOLHIDO","01/01/2023","Calça");
        PedidoTeste p3 = new PedidoTeste(3,300,"AGUARDANDO","31/12/2022","Meia");
        PedidoTeste p4 = new PedidoTeste(4,400,"PAGO","30/12/2022","Ciroulas");
        PedidoTeste p5 = new PedidoTeste(5,500,"FINALIZADO","29/12/2022","Camiseta");
        listaPedidos.add(p1);
        listaPedidos.add(p2);
        listaPedidos.add(p3);
        listaPedidos.add(p4);
        listaPedidos.add(p5);
        return listaPedidos;
    }

    public int getNumero() {
        return numero;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public String getDataCriacao() {
        return dataCriacao;
    }

    public String getRoupas() {
        return roupas;
    }      
}
