/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import br.com.tads.model.Funcionario;
import br.com.tads.model.Usuario;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
/**
 *
 * @author juann
 */
@WebFilter("/controller")
public class AutorizacaoFilter extends HttpFilter implements Filter {
	
        @Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		String action = request.getParameter("action");
		
		boolean usuarioLogado = (usuario!=null);
		boolean actionProtegida = !(action.equals("LoginForm") || action.equals("Login") || action.equals("CadastroForm") || action.equals("Cadastro"));
		boolean actionProtegidaFuncionario = !(action.equals("HomeCliente") || action.equals("OrcamentoLista") || 
                                                        action.equals("PedidoCadastrar") || action.equals("PedidoFilter") || action.equals("PedidoForm") ||
                                                        action.equals("PedidoStatus"));
                
		if(!usuarioLogado && actionProtegida) {
                    if(usuario instanceof Funcionario && actionProtegidaFuncionario){
                        response.sendRedirect("controller?action=HomeFuncionario"); 
                        return;
                    }
                    response.sendRedirect("controller?action=LoginForm");
                    return;
		}
		
		chain.doFilter(request, response);
	}

        @Override
	public void init(FilterConfig fConfig) throws ServletException {}
        @Override
	public void destroy() {}
}
