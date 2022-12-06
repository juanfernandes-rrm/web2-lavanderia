package br.com.tads.model;

import br.com.tads.model.enums.RoupaEnum;

import java.time.LocalDate;

public class Roupa {
    private RoupaEnum peca; //peca e preco no enum
    private int qtdPeca;
    private LocalDate prazoEntrega;
    
    public Roupa(RoupaEnum peca, int qtdPeca) {
        this.peca = peca;
        this.qtdPeca = qtdPeca;
        this.prazoEntrega = LocalDate.now(); //provisorio
    }

    public RoupaEnum getPeca() {
        return peca;
    }

    public int getQtdPeca() {
        return qtdPeca;
    }

    public LocalDate getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(LocalDate prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }
    
    @Override
    public String toString() {
        return "Roupa{" + "peca=" + peca + "qtdPeca=" + qtdPeca + '}';
    }
}
