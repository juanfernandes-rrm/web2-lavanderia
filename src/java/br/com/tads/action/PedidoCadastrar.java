/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.model.BancoDeDados;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import br.com.tads.model.enums.RoupaEnum;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author juann
 */
public class PedidoCadastrar implements Action{
    
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String qtdCalca = request.getParameter("CALCA");
        String qtdBermuda = request.getParameter("BERMUDA");
        String qtdCamisa = request.getParameter("CAMISA");
        String qtdCamiseta = request.getParameter("CAMISETA");
        Pedido pedido = new Pedido(); //provisorio
        
        adicionaPecaNoPedido(RoupaEnum.CALCA, converter(qtdCalca), pedido);
        adicionaPecaNoPedido(RoupaEnum.BERMUDA, converter(qtdBermuda), pedido);
        adicionaPecaNoPedido(RoupaEnum.CAMISA, converter(qtdCamisa), pedido);
        adicionaPecaNoPedido(RoupaEnum.CAMISETA, converter(qtdCamiseta), pedido);
        
        BancoDeDados.adicionarPedido(pedido);
        System.out.println("Id Pedido: "+pedido.getNumero());
        return "redirect:controller?action=OrcamentoPedido&id="+pedido.getNumero();
    }
    
    private int converter(String string){
        if(!(string==null || string.isBlank())){
            return Integer.parseInt(string);
        }
        return 0;
    }
    
    private void adicionaPecaNoPedido(RoupaEnum peca, int qtdPeca,Pedido pedido){
            if(qtdPeca>0){
                Roupa roupa = new Roupa(peca,qtdPeca);
                pedido.adicionarRoupa(roupa);
            }
    }
}
