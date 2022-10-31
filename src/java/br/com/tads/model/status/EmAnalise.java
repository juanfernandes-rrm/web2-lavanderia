package br.com.tads.model.status;

import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;

public class EmAnalise extends StatusPedido {

    public void aprovar(Pedido pedido){
        pedido.setStatusPedido(new EmAberto());
    }

    public void reprovar(Pedido pedido){
        pedido.setStatusPedido(new Rejeitado());
    }
}
