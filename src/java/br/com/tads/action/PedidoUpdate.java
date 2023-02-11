package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Pedido;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class PedidoUpdate implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Object originAttribute = request.getAttribute("origin");
        String origin = "forward:homeFuncionario.jsp";
        if (originAttribute != null) {
            origin = originAttribute.toString();
        }
        String returnPage;
        if ("homeFuncionario.jsp".equals(origin)) {
        returnPage = "forward:homeFuncionario.jsp";
        } else {
        returnPage = "forward:visualPedidos.jsp";
        }
        
        String pedidoString = request.getParameter("pedido");
        if (pedidoString == null) {
            return returnPage;
        }
        long id = Integer.parseInt(pedidoString);
        String acao = request.getParameter("acao");
        List<Pedido> pedidos = (List<Pedido>) request.getAttribute("pedidos");
        
        String estado = null;
        if(null != acao)
            switch (acao) {
            case "recolhido" -> estado = "RECOLHIDO";
            case "lavado" -> estado = "AGUARDANDO";
            case "pago" -> estado = "PAGO";
            case "finalizar" -> estado = "FINALIZADO";
            default -> {estado = null;}
        }
            
            
        if(null != acao){
            try(ConnectionFactory factory = new ConnectionFactory()){
                Connection conn = factory.getConnection();  
                PedidoDAO pedidoDAO = new PedidoDAO(conn);

                Pedido pedido = pedidoDAO.buscar(id);
                pedidoDAO.atualizarEstado(pedido, estado);
                               
                request.setAttribute("pedidos", pedidos);
              } catch (Exception ex) {
                Logger.getLogger(ex.getMessage());
            }
        }

        return returnPage;
    }

}
