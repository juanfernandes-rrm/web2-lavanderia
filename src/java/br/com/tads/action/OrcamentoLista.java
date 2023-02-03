/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Peca;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import br.com.tads.model.status.EmAnalise;
import br.com.tads.model.status.StatusPedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
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
            List<Pedido> pedido = pedidoDAO.buscarPorStatus(new EmAnalise());
            request.setAttribute("listPedidosEmAnalise", pedido);
        } catch (Exception ex) {
            Logger.getLogger(OrcamentoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:orcamentos.jsp";
    }
    
}
