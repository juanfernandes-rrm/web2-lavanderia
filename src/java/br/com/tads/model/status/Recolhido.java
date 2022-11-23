package br.com.tads.model.status;
import br.com.tads.model.Pedido;


/**
 *
 * @author juann
 */
public class Recolhido extends StatusPedido {

    @Override
    public void lavar(Pedido pedido){
        pedido.setStatusPedido(new AguardandoPagamento());
    }
    
}
