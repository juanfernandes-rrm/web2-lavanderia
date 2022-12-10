package br.com.tads.model;

import br.com.tads.model.enums.RoupaEnum;

import java.math.BigDecimal;

public class Roupa {
    private RoupaEnum peca; //peca e preco no enum
    private int qtdPeca;
    
    public Roupa(RoupaEnum peca, int qtdPeca) {
        this.peca = peca;
        this.qtdPeca = qtdPeca;
    }

    @Override
    public String toString() {
        return "Roupa{" + "peca=" + peca + "qtdPeca=" + qtdPeca + '}';
    }
}
