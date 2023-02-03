package br.com.tads.model.status;

import br.com.tads.model.Pedido;

public class EmAnalise extends StatusPedido {

    @Override
    public String status(){
        return "EmAnalise";
    }
    
    @Override
    public void aprovar(Pedido pedido){
        pedido.setStatusPedido(new EmAberto());
    }

    @Override
    public void rejeitar(Pedido pedido){
        pedido.setStatusPedido(new Rejeitado());
    }
    
    @Override
    public void cancelar(Pedido pedido){
        pedido.setStatusPedido(new Cancelado());
    }
}
