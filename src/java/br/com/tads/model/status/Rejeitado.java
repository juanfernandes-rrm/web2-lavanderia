package br.com.tads.model.status;

import br.com.tads.model.Pedido;

public class Rejeitado extends StatusPedido {
    
    @Override
    public String status(){
        return "Rejeitado";
    }
    
    @Override
    public void finalizar(Pedido pedido) {
        pedido.setStatusPedido(new Finalizado());
    }
}
