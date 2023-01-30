/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class PedidoDAO implements DAO<Pedido>{

    private Connection con = null;

    private static final String QUERY_INSERIR_ROUPA_PEDIDO= "INSERT INTO roupa_pedido(pedido_fk, roupa_fk, qtd_peca) VALUES (?, ?, ?)";
    private static final String QUERY_INSERIR= "INSERT INTO pedido(prazo, status_pedido, data_criacao) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT numero, prazo, status_pedido, data_criacao FROM pedido";
    
    public PedidoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar PedidoDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Pedido buscar(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pedido> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Pedido pedido) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setDate(1, Date.valueOf(pedido.getOrcamento().getPrazo()));
            st.setString(2, pedido.getStatusPedido().status());
            st.setTimestamp(3, Timestamp.valueOf(pedido.getDataCriacao()));
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setNumero(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Criação de pedido falhou.");
                }
            }
            
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir pedido: "+ QUERY_INSERIR + "/ "+ pedido.toString(), e);
        }
    }

    @Override
    public void atualizar(Pedido t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Pedido t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private void inserirRoupaPedido(int numero_pedido, Roupa roupa) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ROUPA_PEDIDO)){
            st.setInt(1, numero_pedido);
            st.setInt(2, roupa.getId());
            //st.setInt(3, roupa.getQtdPeca());
            
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir pedido: "+ QUERY_INSERIR_ROUPA_PEDIDO + "/ "+ roupa.toString(), e);
        }
    }
}
