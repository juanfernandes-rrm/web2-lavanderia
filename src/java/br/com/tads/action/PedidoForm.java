/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.RoupaDAO;
import br.com.tads.exceptions.DAOException;
import java.sql.Connection;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class PedidoForm implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(Connection conn = ConnectionFactory.getConnection()) {
            RoupaDAO roupaDAO = new RoupaDAO(conn);
            request.setAttribute("listRoupa", roupaDAO.buscarTodos());
        } catch (DAOException | SQLException ex) {
            Logger.getLogger(PedidoForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "forward:cadastraPedido.jsp";
    }
    
}
