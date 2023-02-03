package br.com.tads.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Orcamento {
    private BigDecimal valor; //valorTotal
    private LocalDate prazo; //prazo de entrega

    public Orcamento(BigDecimal valor, LocalDate prazo) {
        this.valor = valor;
        this.prazo = prazo;
    }

    
    
    public Orcamento() {
        this.valor = new BigDecimal(BigInteger.ZERO);
        this.prazo = LocalDate.now();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void somaValor(BigDecimal valor){
        this.valor = this.valor.add(valor);
    }
        
    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        if(this.prazo.isBefore(prazo)){
            this.prazo = prazo;
        }
    }



}
