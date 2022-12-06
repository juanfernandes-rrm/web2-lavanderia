/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author juann
 */
public class OrcamentoLista implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listPedidosEmAnalise", BancoDeDados.getPedidosEmAnalise());
        return "forward:orcamentos.jsp";
    }
    
}
