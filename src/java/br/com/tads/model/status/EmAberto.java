package br.com.tads.model.status;

import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;

public class EmAberto extends StatusPedido {
    @Override
    public void finalizar(Pedido pedido) {
        pedido.setStatusPedido(new Finalizado());
    }
}
