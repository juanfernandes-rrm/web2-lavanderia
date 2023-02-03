/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Peca;
import br.com.tads.model.Pedido;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 *
 * @author juann
 */
public class PedidoDAO implements DAO<Pedido>{

    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO pedido(prazo, status_pedido, data_criacao) VALUES (?, ?, ?)";
    private static final String QUERY_INSERIR_ROUPA = "INSERT INTO roupa_pedido(pedido_fk, roupa_fk, qtd_peca) VALUES (?, ?, ?)";
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
                    inserirPecas(pedido.getNumero(), pedido.getPecas());
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
    
    
    private void inserirPecas(int numeroPedido, List<Peca> pecas){
        pecas.stream().forEach(peca -> {
            try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ROUPA)){
                st.setInt(1, numeroPedido);
                st.setInt(2, peca.getId());
                st.setInt(3, peca.getQtd());

                st.executeUpdate();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        });   
    }
}
