package br.com.tads.model.status;

import br.com.tads.exceptions.DomainExcepction;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;

public abstract class StatusPedido {

    public void aprovar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser aprovado");
    }

    public void reprovar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser reprovado");
    }

    public void finalizar(Pedido pedido){
        throw new DomainExcepction("Pedido não pode ser finalizado");
    }
}
