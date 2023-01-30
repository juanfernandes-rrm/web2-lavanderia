/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.dao.RoupaDAO;
import br.com.tads.dao.RoupaPedidoDAO;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import br.com.tads.model.RoupaPedido;
import br.com.tads.model.enums.RoupaEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class PedidoCadastrar implements Action{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Enumeration<String> parameterNames = request.getParameterNames();

        Pedido pedido = new Pedido();
        Orcamento orcamento = new Orcamento();
        
        while (parameterNames.hasMoreElements()) {
            String id_roupa = (String) parameterNames.nextElement();
            String qtdPeca = request.getParameter(id_roupa);
            
            if(converter(qtdPeca)>0){
                try(Connection conn = ConnectionFactory.getConnection()) {
                    RoupaDAO roupaDAO = new RoupaDAO(conn);
                    Roupa roupa = roupaDAO.buscar(converter(id_roupa));
                    System.out.println("Roupa: "+roupa.toString());
                    
                    orcamento.setPrazo(LocalDate.now().plusDays(roupa.getPrazoEntrega()));
                    orcamento.somaValor(BigDecimal.valueOf(roupa.getValor()));
                    pedido.setOrcamento(orcamento);
                    
                    
                    RoupaPedidoDAO roupaPedidoDAO = new RoupaPedidoDAO(conn);
                    RoupaPedido roupaPedido = new RoupaPedido(roupa, pedido, qtdPeca);
                    roupaPedidoDAO.inserirRoupaPedido(roupaPedido);
                } catch (DAOException | SQLException ex) {
                    Logger.getLogger(PedidoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        try(Connection conn = ConnectionFactory.getConnection()) {
            PedidoDAO pedidoDAO = new PedidoDAO(conn);
            pedidoDAO.inserir(pedido);
        } catch (DAOException | SQLException ex) {
            Logger.getLogger(PedidoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "redirect:controller?action=HomeCliente";
    }
    
    private int converter(String string){
        try{
            if(!(string==null || string.isBlank())){
                return Integer.parseInt(string);
            }
        }catch(NumberFormatException e){
            return 0;
        }
        return 0;
    }
}
