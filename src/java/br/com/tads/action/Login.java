/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.UsuarioDAO;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Cliente;
import br.com.tads.model.Funcionario;
import java.sql.Connection;
import br.com.tads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class Login implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        if(login != null && senha != null) {
            try(ConnectionFactory factory = new ConnectionFactory()){
                Connection con = factory.getConnection();
                UsuarioDAO usuarioDAO = new UsuarioDAO(con);
                Usuario usuario = usuarioDAO.buscar(login, senha);
                
                if(usuario != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("usuario", usuario);
                    
                    if ((usuario instanceof Cliente) || usuario.getEmail().equals("cliente@email.com")){
                        return "redirect:controller?action=HomeCliente";
                    }
                    if ((usuario instanceof Funcionario) || usuario.getEmail().equals("funcionario@email.com")){
                        return "redirect:controller?action=HomeFuncionario";
                    }
                    
                    return "redirect:controller?action=HomeCliente";
                }
            } catch (DAOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "redirect:controller?action=LoginForm";
    }
    
}
