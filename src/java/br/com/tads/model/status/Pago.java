package br.com.tads.model.status;

import br.com.tads.model.Pedido;

/**
 *
 * @author juann
 */
public class Pago extends StatusPedido {

    @Override
    public void finalizar(Pedido pedido){
        pedido.setStatusPedido(new Finalizado());
    }
}
