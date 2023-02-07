/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Cliente;
import br.com.tads.model.Pedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class HomeCliente implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
            PedidoDAO pedidoDAO = new PedidoDAO(factory.getConnection());
            HttpSession session = request.getSession();
            Cliente cliente = (Cliente) session.getAttribute("usuario");
            
            List<Pedido> pedidos = pedidoDAO.buscarTodos(cliente.getId());
            request.setAttribute("listPedido", pedidos);
        } catch (Exception ex) {
            Logger.getLogger(HomeCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:homeCliente.jsp";
    }
    
}
