/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model;

import br.com.tads.model.status.EmAnalise;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juann
 */
public class BancoDeDados implements Serializable{
    private static List<Pedido> pedidos = new ArrayList<>();
    private static int numeroPedido = 1;
    
    public BancoDeDados() {
        pedidos.add(new Pedido());
    }
    
    public static void adicionarPedido(Pedido pedido){
        pedido.setNumero(numeroPedido++);
        pedidos.add(pedido);
    }

    public static List<Pedido> getPedidos() {
        return pedidos;
    }
    
    public static List<Pedido> getPedidosEmAnalise() {
        List<Pedido> pedidosEmAnalise = new ArrayList();
        for(Pedido pedido:pedidos){
            if(pedido.getStatusPedido() instanceof EmAnalise){
                pedidosEmAnalise.add(pedido);
            }
        }
        return pedidosEmAnalise;
    }
    
    public static Pedido getPedido(int id){
        for(Pedido pedido:pedidos){
            if(pedido.getNumero() == id){
                return pedido;
            }
        }
        return null;
    }
}
