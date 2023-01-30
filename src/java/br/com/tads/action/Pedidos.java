/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import br.com.tads.model.status.EmAnalise;
import br.com.tads.model.status.StatusPedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class Pedidos implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String nomeDaClasse = "br.com.tads.model.status."+status;
        StatusPedido statusPedido = new EmAnalise();
        try {
            Class classe =  Class.forName(nomeDaClasse);
            statusPedido = (StatusPedido)classe.newInstance();
            
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(OrcamentoLista.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("listPedidos", BancoDeDados.getPedidoPorStatus(statusPedido));
        return "forward:pedidos.jsp";
    }
    
}
