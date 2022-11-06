/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import br.com.tads.action.Action;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 *
 * @author juann
 */
@WebServlet(name = "Controller", urlPatterns = {"/controller"})
public class Controller extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String actionNome = request.getParameter("action");
        System.out.println(actionNome);

        String nomeDaClasse = "br.com.tads.action."+actionNome;
        String path;
        try {
            Class classe = Class.forName(nomeDaClasse); //carrega a classe com o nome
            Action action = (Action)classe.newInstance();
            path = action.execute(request, response);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
                 | IOException e) {
            throw new ServletException(e);
        }


        String[] prefixAndPath = path.split(":");//[0] prefixo, [1] jsp

        if(prefixAndPath[0].equals("forward")) {
            RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+prefixAndPath[1]);
            rd.forward(request, response);
        }else {
            response.sendRedirect(prefixAndPath[1]);
        }
    }

}
