package br.com.tads;

import br.com.tads.model.Pedido;

public class main {
    public static void main(String[] args) {
        Pedido pedido = new Pedido();
        System.out.println(pedido.getDataCriacao());
        System.out.println(pedido.getStatusPedido());
        pedido.aprovar();
        System.out.println(pedido.getStatusPedido());
    }
}
