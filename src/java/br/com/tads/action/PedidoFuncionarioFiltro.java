   
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.model.Pedido;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class PedidoFuncionarioFiltro implements Action {


    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String filtro = request.getParameter("filtro");
        
        String iniDataString = request.getParameter("iniData");
        String fimDataString = request.getParameter("fimData");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate iniData;
        LocalDate fimData;
        
        List<Pedido> pedidos = new ArrayList<>();
        
        String origin = request.getParameter("origin");
        String returnPage;
        if ("homeFuncionario.jsp".equals(origin)) {
            returnPage = "forward:homeFuncionario.jsp";
        } else {
            returnPage = "forward:visualPedidos.jsp";
        }
    
        if (iniDataString == null || iniDataString.trim().isEmpty()) {
            iniData = LocalDate.now();
        } else {
            iniData = LocalDate.parse(iniDataString, formatter);
        }
        System.out.println("DATA INICIO: "+iniData);
        
        if (fimDataString == null || fimDataString.trim().isEmpty()) {
            fimData = LocalDate.now();
        } else {
            fimData = LocalDate.parse(fimDataString, formatter);
        }
        
        System.out.println("DATA FIM: "+fimData);
        try(ConnectionFactory factory = new ConnectionFactory()){
            Connection conn = factory.getConnection();  
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            switch (filtro) {
                case "todos" -> request.setAttribute("pedidos", pedidoDAO.buscarTodos());
                case "hoje" -> request.setAttribute("pedidos", pedidoDAO.buscarPedidosDeHoje());
                case "range" -> request.setAttribute("pedidos",pedidoDAO.buscarPedidosPorData(iniData, fimData));
                default -> {request.setAttribute("pedidos", pedidoDAO.buscarTodos());}   
            }
        } catch (Exception ex) {
            Logger.getLogger(ex.getMessage());
        }
        request.setAttribute("filtro", filtro);

        return  returnPage;
    }
}
