/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.FuncionarioDAO;
import br.com.tads.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class ListarFuncionario implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(factory.getConnection());
            
            List<Funcionario> funcionarios = funcionarioDAO.buscarTodos();
            request.setAttribute("funcionarios", funcionarios);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return "forward:manterFuncionario.jsp";
    }  
}
