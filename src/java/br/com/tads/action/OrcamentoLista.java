/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Pedido;
import br.com.tads.model.status.EmAnalise;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class OrcamentoLista implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
            PedidoDAO pedidoDAO = new PedidoDAO(factory.getConnection());
            List<Pedido> pedidos = pedidoDAO.buscarPorStatus(new EmAnalise());
            request.setAttribute("listPedidosEmAnalise", pedidos);
        } catch (Exception ex) {
            Logger.getLogger(OrcamentoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:orcamentos.jsp";
    }
    
}