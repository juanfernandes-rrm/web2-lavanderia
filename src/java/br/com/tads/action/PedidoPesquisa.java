/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class PedidoPesquisa implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pesquisaPedido"));
        
        try(ConnectionFactory factory = new ConnectionFactory()) {
            PedidoDAO pedidoDAO = new PedidoDAO(factory.getConnection());
            List<Pedido> pedido = new ArrayList<>();
            pedido.add(pedidoDAO.buscar(pedidoId));
            request.setAttribute("listPedido", pedido);
        }catch (Exception ex) {
            Logger.getLogger(PedidoPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:homeCliente.jsp";
    }    
}
