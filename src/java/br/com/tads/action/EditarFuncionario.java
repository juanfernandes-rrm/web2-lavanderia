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
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class EditarFuncionario implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
            UsuarioDAO usuarioDAO = new UsuarioDAO(factory.getConnection());
            
            String idString = request.getParameter("id");
            Usuario usuario = new Funcionario();
            if (idString != null) {
                try {
                    int id = Integer.parseInt(idString);
                    
                    usuario = usuarioDAO.buscar(id);
                    
                } catch (NumberFormatException e) {
                    request.setAttribute("mensagem", "Erro ao selecionar Funcionário");
                    return "forward:manterFuncionario.jsp";
                }         
 
            } else {
                request.setAttribute("mensagem", "Erro ao selecionar Funcionário");
                return "forward:manterFuncionario.jsp";
            }
            
            request.setAttribute("funcionario", usuario);
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        return "forward:editarFuncionario.jsp";
    } 
    
}
