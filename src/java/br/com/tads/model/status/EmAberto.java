package br.com.tads.model.status;

import br.com.tads.model.Pedido;

public class EmAberto extends StatusPedido {
    
    @Override
    public String status(){
        return "Em Aberto";
    }
    
    @Override
    public void cancelar(Pedido pedido){
        pedido.setStatusPedido(new Cancelado());
    }
    
    @Override
    public void recolher(Pedido pedido){
        pedido.setStatusPedido(new Recolhido());
    }
    
    //TODO:
    //verificar esse aqui
    @Override
    public void finalizar(Pedido pedido) {
        pedido.setStatusPedido(new Finalizado());
    }
}
