/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import br.com.tads.model.status.EmAberto;
import br.com.tads.model.status.StatusPedido;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        request.setAttribute("listPedido", BancoDeDados.getPedidoPorStatus(statusPedido));
        return "forward:homeCliente.jsp";
    }
    
}
