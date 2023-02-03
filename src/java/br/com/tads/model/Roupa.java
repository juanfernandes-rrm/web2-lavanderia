package br.com.tads.model;

public class Roupa {
    private int id;
    private String peca; //peca e preco no enum
    private double valor;
    private int prazoEntrega;// talvez representar por dias úteis

    public Roupa(int id, String peca, double valor, int prazoEntrega) {
        this.id = id;
        this.peca = peca;
        this.valor = valor;
        this.prazoEntrega = prazoEntrega;
    }
    
    //ajustar para calcular o valor
    public Roupa(String peca, double valor, int prazoEntrega) {
        this.peca = peca;
        this.valor = valor;
        this.prazoEntrega = prazoEntrega;
    }

    public Roupa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getPeca() {
        return peca;
    }

    public void setPeca(String peca) {
        this.peca = peca;
    }

    public int getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(int prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    @Override
    public String toString() {
        return "Roupa{" + "id=" + id + ", peca=" + peca + ", valor=" + valor + ", prazoEntrega=" + prazoEntrega + '}';
    }
}
