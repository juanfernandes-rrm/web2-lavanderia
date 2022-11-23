/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.model.status;
import br.com.tads.model.Pedido;


/**
 *
 * @author juann
 */
public class Recolhido extends StatusPedido {

    @Override
    public void lavar(Pedido pedido){
        pedido.setStatusPedido(new AguardandoPagamento());
    }
    
}
