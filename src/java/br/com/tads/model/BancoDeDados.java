/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juann
 */
public class BancoDeDados implements Serializable{
    private static List<Pedido> pedidos = new ArrayList<>();

    public BancoDeDados() {
        pedidos.add(new Pedido());
    }
    
    public static void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public static List<Pedido> getPedidos() {
        return pedidos;
    }
}
