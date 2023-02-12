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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class RoupaUpdateForm implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Roupa roupa;
        try(ConnectionFactory factory = new ConnectionFactory()){
            RoupaDAO roupaDAO = new RoupaDAO(factory.getConnection());
            roupa = roupaDAO.buscar(id);
            request.setAttribute("roupa", roupa);
        } catch (Exception ex) {
            Logger.getLogger(RoupaCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:editaRoupa.jsp";
    }
    
}
