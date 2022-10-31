package br.com.tads.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Orcamento {
    private BigDecimal valor;
    private LocalDate prazo;

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }


}
