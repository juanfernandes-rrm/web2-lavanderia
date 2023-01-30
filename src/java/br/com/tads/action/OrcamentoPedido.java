/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author juann
 */
//Action que monta o orçamento
public class OrcamentoPedido implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        System.out.println("ID Pedido:"+id);
        Pedido pedido = BancoDeDados.getPedido(id);
        List<Roupa> roupas = pedido.getRoupas();
        Orcamento orcamento = new Orcamento();
        
        for(Roupa roupa:roupas){
            System.out.println("Preco roupa: "+roupa.getPeca().getPreco()+" + qtdPeca= "+roupa.getQtdPeca());
            orcamento.somaValor(roupa.getPeca().getPreco().multiply(BigDecimal.valueOf(roupa.getQtdPeca())));
            LocalDate prazoEntrega;
            if(orcamento.getPrazo().isAfter(roupa.getPrazoEntrega())){
                prazoEntrega = orcamento.getPrazo();
            }else{
                prazoEntrega = roupa.getPrazoEntrega();
            }
            orcamento.setPrazo(prazoEntrega);
        }
        
        pedido.setOrcamento(orcamento);
        
        return "redirect:controller?action=OrcamentoLista";
    }
    
}
