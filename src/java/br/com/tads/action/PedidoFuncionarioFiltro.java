   
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


public class PedidoFuncionarioFiltro implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String filtro = request.getParameter("filtro");
        String iniDataString = request.getParameter("iniData");
        String fimDataString = request.getParameter("fimData");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date iniData = null, fimData = null;
        List<Pedido> pedidos = new ArrayList<>();
    
        if (iniDataString == null || iniDataString.trim().isEmpty()) {
            // Set valor para uma data default
            iniData = new Date();
        } else {
            try {
                iniData = dateFormat.parse(iniDataString);
            } catch (ParseException e) {
                // Set valor para uma data default
                iniData = new Date();
            }
        }
        if (fimDataString == null || fimDataString.trim().isEmpty()) {
            // Set valor para uma data default
            fimData = new Date();
        } else {
            try {
                fimData = dateFormat.parse(iniDataString);
            } catch (ParseException e) {
                // Set valor para uma data default
                fimData = new Date();
            }
        }
        
        if(null != filtro){
            try(ConnectionFactory factory = new ConnectionFactory()){
                Connection conn = factory.getConnection();  
                PedidoDAO pedidoDAO = new PedidoDAO(conn);
                switch (filtro) {
                    case "todos" -> pedidos.add((Pedido) pedidoDAO.buscarTodos());
                    case "hoje" -> pedidos.add((Pedido) pedidoDAO.buscarPedidosDeHoje());
                    case "range" -> pedidos.add(pedidoDAO.buscarPedidosPorData(iniData, fimData));
                    default -> {pedidos.add((Pedido) pedidoDAO.buscarTodos());}   
                }
            } catch (Exception ex) {
                Logger.getLogger(ex.getMessage());
            }
            request.setAttribute("pedidos", pedidos);
            request.setAttribute("filtro", filtro);
        }
        
        String origin = request.getAttribute("origin").toString();
        String returnPage;
        if ("homeFuncionario.jsp".equals(origin)) {
        returnPage = "forward:homeFuncionario.jsp";
        } else {
        returnPage = "forward:visualPedidos.jsp";
        }

        return returnPage;
    }

}
