/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model;

import br.com.tads.model.status.EmAnalise;
import br.com.tads.model.status.StatusPedido;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        return pedidos.stream()
                .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                .collect(Collectors.toList());
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
    
    public static List<Pedido> getPedidoPorStatus(StatusPedido statusPedido){
        System.out.println("banco pedidos: "+pedidos.toString());
        System.out.println("Banco Status:"+statusPedido);
        return pedidos.stream()
                .filter(pedido -> pedido.getStatusPedido().getClass() == statusPedido.getClass())
                .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                .collect(Collectors.toList());
    }
}
