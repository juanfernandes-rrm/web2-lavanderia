/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Pedido;
import br.com.tads.model.status.EmAberto;
import br.com.tads.model.status.StatusPedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class PedidoFilter implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        
        String nomeDaClasse = "br.com.tads.model.status."+status;
        StatusPedido statusPedido = new EmAberto();
        try {
            Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
            statusPedido = (StatusPedido)classe.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException  e) {
            throw new ServletException(e);
        }
        
        try(ConnectionFactory factory = new ConnectionFactory()) {
            Connection conn = factory.getConnection();
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            List<Pedido> pedidos = pedidoDAO.buscarPorStatus(statusPedido);        
            request.setAttribute("listPedido", pedidos);
        } catch (Exception ex) {
            Logger.getLogger(PedidoFilter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:homeCliente.jsp";
    }
    
}
