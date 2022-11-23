package br.com.tads.model.status;

import br.com.tads.model.Pedido;

public class EmAberto extends StatusPedido {
    
    @Override
    public void cancelar(Pedido pedido){
        pedido.setStatusPedido(new Cancelado());
    }
    
    @Override
    public void recolher(Pedido pedido){
        pedido.setStatusPedido(new Recolhido());
    }
    
    @Override
    public void finalizar(Pedido pedido) {
        pedido.setStatusPedido(new Finalizado());
    }
}
