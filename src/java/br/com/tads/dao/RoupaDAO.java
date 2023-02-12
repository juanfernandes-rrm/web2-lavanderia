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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.postgresql.util.PSQLException;

/**
 *
 * @author juann
 */
public class RoupaDAO implements DAO<Roupa>{

    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO roupa(peca, valor, prazo_entrega) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT id, peca, valor, prazo_entrega FROM roupa";
    private static final String QUERY_BUSCAR= "SELECT id, peca, valor, prazo_entrega FROM roupa WHERE roupa.id = ?";
    private static final String QUERY_DELETE = "DELETE FROM roupa WHERE roupa.id = ?";
    private static final String QUERY_UPDATE = "UPDATE roupa SET peca = ?, valor = ?, prazo_entrega = ? WHERE roupa.id = ?";
    
    public RoupaDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar RoupaDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Roupa buscar (long id) throws DAOException{
        Roupa roupa = new Roupa();
        try (PreparedStatement stmt = con.prepareStatement("SELECT id, peca, valor, prazo_entrega FROM roupa WHERE roupa.id = ?")) {
            stmt.setInt(1, (int) id);
            try (ResultSet rs = stmt.executeQuery()) { 
                if (rs.next()) {
                    roupa.setId(rs.getInt("id"));
                    roupa.setPeca(rs.getString("peca"));
                    roupa.setValor(rs.getDouble("valor"));
                    roupa.setPrazoEntrega(rs.getInt("prazo_entrega"));
                } else {
                    System.out.println("No object found with id " + id);
                }

              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        return roupa;
    }

    @Override
    public List<Roupa> buscarTodos() throws DAOException {
        List<Roupa> lista = new ArrayList<>();
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS);
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
            throw new DAOException("Erro ao inserir roupa: "+ QUERY_INSERIR + "/ "+ roupa.toString(), e);
        }
    }

    @Override
    public void atualizar(Roupa roupa) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_UPDATE)){
            st.setString(1, roupa.getPeca());
            st.setDouble(2, roupa.getValor());
            st.setInt(3, roupa.getPrazoEntrega());
            st.setInt(4, roupa.getId());
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DAOException("Erro ao atualizar roupa: "+ QUERY_UPDATE + "/ "+ roupa.toString(), e);
        }
    }

    @Override
    public void remover(Roupa roupa) throws DAOException {
        //TODO: adicionar tratamento de erro para quando nao poder excluir pois existem um pedido referenciando esta roupa (violation constraint fk)
        try(PreparedStatement st = con.prepareStatement(QUERY_DELETE)){
            st.setInt(1, roupa.getId());
            st.executeQuery();
        } catch (SQLException ex) {
            throw new DAOException("Erro ao atualizar roupa: "+ QUERY_DELETE + "/ "+ roupa.toString(), ex);
        }
    }
    
}
