package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Funcionario;
import br.com.tads.model.Pedido;
import br.com.tads.model.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoStatus implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //aprovar pedido
        //rejeitar pedido
        String status = request.getParameter("status");
        int id = Integer.parseInt(request.getParameter("id"));
        
        try(ConnectionFactory factory = new ConnectionFactory()){
            PedidoDAO pedidoDAO = new PedidoDAO(factory.getConnection());
            Pedido pedido = pedidoDAO.buscar(id);
            
            switch(status){
                case "Aprovar" -> {
                  pedido.aprovar();
                }
                case "Rejeitar" -> {
                    pedido.rejeitar();
                }
                case "Cancelar" -> {
                    pedido.cancelar();
                }
                case "Recolher" ->{
                    pedido.recolher();
                }
                case "Lavar" ->{
                    pedido.lavar();
                }
                case "Pagar" ->{
                    pedido.pagar();
                }
                case "Finalizar" ->{
                    pedido.finalizar();
                }
            }
            pedidoDAO.atualizar(pedido);
        } catch (Exception ex) {
            Logger.getLogger(PedidoStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        if (usuario instanceof Funcionario){
            String origin = request.getParameter("origin");
            if(origin != null){
                return "redirect:controller?action="+origin;
            }
            return "redirect:controller?action=HomeFuncionario";
        }
        return "redirect:controller?action=HomeCliente";
    }
}
