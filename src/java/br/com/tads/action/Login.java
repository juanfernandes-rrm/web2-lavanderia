/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.Cliente;
import br.com.tads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author juann
 */
public class Login implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        System.out.println("LOGIN: "+login);
        System.out.println("SENHA "+senha);

        if(login != null) {
            HttpSession session = request.getSession();
            Usuario usuario = new Cliente(login, senha);
            session.setAttribute("usuario", usuario);
            System.out.println("LOGIN != NULL");
            return "redirect:controller?action=HomeFuncionario";
        }else {
            return "redirect:controller?action=LoginForm";
        }    
    }
    
}
