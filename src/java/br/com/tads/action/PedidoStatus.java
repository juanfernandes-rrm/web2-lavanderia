/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PedidoStatus implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //aprovar pedido
        //rejeitar pedido
        String status = request.getParameter("status");
        int id = Integer.parseInt(request.getParameter("id"));
        Pedido pedido = BancoDeDados.getPedido(id);
        
        switch(status){
            case "Aprovar" -> {
              pedido.aprovar();
            }
            case "Rejeitar" -> {
                pedido.rejeitar();
            }
            case "Pagar" ->{
                pedido.recolher();
                pedido.lavar();
                pedido.pagar();
                pedido.finalizar();
            }
            case "Cancelar" -> {
                pedido.cancelar();
            }
        }
        
        return "redirect:controller?action=HomeCliente";
    }
    
}
