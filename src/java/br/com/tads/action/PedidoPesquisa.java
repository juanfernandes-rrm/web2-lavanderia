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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juann
 */
public class PedidoPesquisa implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pesquisaPedido"));
        List<Pedido> pedido = new ArrayList<>();
        pedido.add(BancoDeDados.getPedido(pedidoId));
        request.setAttribute("listPedido", pedido);
        return "forward:homeCliente.jsp";
    }
    
}
