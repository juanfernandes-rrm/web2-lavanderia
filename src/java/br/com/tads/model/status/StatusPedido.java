package br.com.tads.model.status;

import br.com.tads.exceptions.DomainExcepction;
import br.com.tads.model.Pedido;

public abstract class StatusPedido {

    public void aprovar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser aprovado");
    }

    public void rejeitar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser reprovado");
    }
    
    public void cancelar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser cancelado");
    }

    public void recolher(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser recolhido");
    }
    
    public void lavar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser lavado");
    }
    
    public void pagar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser pago");
    }
    
    public void finalizar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser finalizado");
    }
}
