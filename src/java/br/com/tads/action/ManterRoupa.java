/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.RoupaDAO;
import br.com.tads.model.Roupa;
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
public class ManterRoupa implements Action{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
           RoupaDAO roupaDAO = new RoupaDAO(factory.getConnection());
           List<Roupa> roupas = roupaDAO.buscarTodos();
           request.setAttribute("roupas", roupas);
        } catch (Exception ex) {
            Logger.getLogger(ManterRoupa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:roupa.jsp";
    }
}
