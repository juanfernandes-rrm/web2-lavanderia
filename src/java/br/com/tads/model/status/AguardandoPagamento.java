package br.com.tads.model.status;

import br.com.tads.model.Pedido;

/**
 *
 * @author juann
 */
public class AguardandoPagamento extends StatusPedido {

    @Override
    public String status(){
        return "AguardandoPagamento";
    }
    
    @Override
    public void pagar(Pedido pedido){
        pedido.setStatusPedido(new Pago());
    }
}
