package br.com.tads.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

public class Orcamento {
    private BigDecimal valor;
    private LocalDate prazo;

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
        this.prazo = prazo;
    }



}
