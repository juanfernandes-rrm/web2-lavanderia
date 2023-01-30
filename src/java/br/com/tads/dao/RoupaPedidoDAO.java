/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import br.com.tads.model.RoupaPedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author juann
 */
public class RoupaPedidoDAO{
    
    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO roupa_pedido(pedido_fk, roupa_fk, qtd_peca) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT pedido_fk, roupa_fk, qtd_peca FROM roupa_pedido";;
    
    public RoupaPedidoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar RoupaPedidoDAO.");
        }
        this.con= con;
    }
    
    public void inserirRoupaPedido(RoupaPedido roupaPedido) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR)){
            st.setInt(1, roupaPedido.getPedido().getNumero());
            st.setInt(2, roupaPedido.getRoupa().getId());
            st.setInt(3, roupaPedido.getQtd());
            
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir pedido: "+ QUERY_INSERIR + "/ "+ roupaPedido.toString(), e);
        }
    }
}
