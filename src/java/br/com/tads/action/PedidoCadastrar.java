/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.dao.RoupaDAO;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Peca;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
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
            String idRoupa = (String) parameterNames.nextElement();
            String qtdPeca = request.getParameter(idRoupa);
            
            //adiciona roupas no pedido
            int qtd = converter(qtdPeca);
            if(qtd>0){
                try(ConnectionFactory factory = new ConnectionFactory()) {
                    Connection conn = factory.getConnection();
                    
                    RoupaDAO roupaDAO = new RoupaDAO(conn);
                    Roupa roupa = roupaDAO.buscar(converter(idRoupa));
                    Peca peca = new Peca(roupa, qtd);
                    
                    orcamento.setPrazo(LocalDate.now().plusDays(roupa.getPrazoEntrega()));
                    orcamento.somaValor(BigDecimal.valueOf(roupa.getValor()));
                    
                    pedido.setOrcamento(orcamento);
                    pedido.adicionarPeca(peca);
                    
                    PedidoDAO pedidoDAO = new PedidoDAO(conn);
                    pedidoDAO.inserir(pedido);
                } catch (DAOException | SQLException ex) {
                    Logger.getLogger(PedidoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Exception ex) {
                    Logger.getLogger(PedidoCadastrar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return "redirect:controller?action=HomeCliente";
    }
    
    private int converter(String num){
        if(!"PedidoCadastrar".equals(num)){
            if(!num.isEmpty() && !num.isBlank()){
                try{
                    return Integer.parseInt(num);
                }catch(NumberFormatException e){
                    e.printStackTrace();
                }
            }
        }
        return 0;
    }
}
