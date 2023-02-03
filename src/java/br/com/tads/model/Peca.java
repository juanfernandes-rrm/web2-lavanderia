/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model;

/**
 *
 * @author juann
 */

//agrupa uma roupa e sua quantidade para compor o pedido
public class Peca extends Roupa {
    private int qtd;

    public Peca(Roupa roupa, int qtd) {
        super(roupa.getId(), roupa.getPeca(), roupa.getValor(), roupa.getPrazoEntrega());
        this.qtd = qtd;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
