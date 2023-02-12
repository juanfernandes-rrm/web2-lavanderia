/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.UsuarioDAO;
import br.com.tads.model.Funcionario;
import br.com.tads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ListarFuncionario implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionFactory factory = null;
        try {
            factory = new ConnectionFactory();
            UsuarioDAO usuarioDAO = new UsuarioDAO(factory.getConnection());
            
            List<Funcionario> funcionarios = usuarioDAO.buscarFuncionarios();
            request.setAttribute("funcionarios", funcionarios);
        } catch (Exception ex) {
            Logger logger = Logger.getLogger(ListarFuncionario.class.getName());
            logger.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (factory != null) {
                try {
                    factory.close();
                } catch (Exception ex) {
                    Logger logger = Logger.getLogger(ListarFuncionario.class.getName());
                    logger.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        }
        return "forward:manterFuncionario.jsp";
    }    
}
