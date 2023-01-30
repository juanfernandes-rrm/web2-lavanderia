/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Roupa;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juann
 */
public class RoupaDAO implements DAO<Roupa>{

    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO roupa(peca, valor, prazo_entrega) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT id, peca, valor, prazo_entrega FROM roupa";
    private static final String QUERY_BUSCAR= "SELECT id, peca, valor, prazo_entrega FROM roupa WHERE roupa.id = ?";
    
    public RoupaDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar RoupaDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Roupa buscar(long id) throws DAOException {
        Roupa roupa = new Roupa();
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR)){
            st.setInt(1, (int) id);
            st.execute();
            try(ResultSet rs = st.getResultSet()){
		while(rs.next()) {
                    roupa.setId(rs.getInt(1));
                    roupa.setPeca(rs.getString(2));
                    roupa.setValor(rs.getDouble(3));
                    roupa.setPrazoEntrega(rs.getInt(4));
		}
            }
        }catch(SQLException e) {
            throw new DAOException("Erro buscando roupa: "+QUERY_BUSCAR_TODOS, e);
        }
        return roupa;
    }

    @Override
    public List<Roupa> buscarTodos() throws DAOException {
        List<Roupa> lista = new ArrayList<>();
        try(
            PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS);
            ResultSet rs = st.executeQuery()) {
            while(rs.next()) {
                Roupa roupa = new Roupa();
                roupa.setId(rs.getInt("id"));
                roupa.setPeca(rs.getString("peca"));
                roupa.setValor(rs.getDouble("valor"));
                roupa.setPrazoEntrega(rs.getInt("prazo_entrega"));
                lista.add(roupa);
            }
            return lista;
        }catch(SQLException e) {
            throw new DAOException("Erro buscando todas as roupas: "+QUERY_BUSCAR_TODOS, e);
        }
    }

    @Override
    public void inserir(Roupa roupa) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, roupa.getPeca());
            st.setDouble(2, roupa.getValor());
            st.setInt(3, roupa.getPrazoEntrega());
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    roupa.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Criação de roupa falhou.");
                }
            }
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir pedido: "+ QUERY_INSERIR + "/ "+ roupa.toString(), e);
        }
    }

    @Override
    public void atualizar(Roupa t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Roupa t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
