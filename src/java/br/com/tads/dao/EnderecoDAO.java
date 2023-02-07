/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Endereco;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class EnderecoDAO implements DAO<Endereco>{

    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO endereco(estado, cidade, bairro, rua, numero) VALUES (?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR= "SELECT id, estado, cidade, bairro, rua, numero FROM endereco WHERE endereco.id = ?";
    private static final String QUERY_BUSCAR_TODOS= "SELECT id, estado, cidade, bairro, rua, numero FROM endereco";
    
    public EnderecoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar EnderecoDAO.");
        }
        this.con= con;
    }
    @Override
    public Endereco buscar(long id) throws DAOException {
        Endereco endereco = new Endereco();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setInt(1, (int) id);
            try (ResultSet rs = stmt.executeQuery()) { 
                if (rs.next()) {
                    endereco.setId(rs.getInt("id"));
                    endereco.setEstado(rs.getString("estado"));
                    endereco.setCidade(rs.getString("cidade"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setRua(rs.getString("rua"));
                    endereco.setNumero(rs.getString("numero"));
                } else {
                    System.out.println("No object found with id " + id);
                }

              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        return endereco;
    }

    @Override
    public List<Endereco> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Endereco endereco) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, endereco.getEstado());
            st.setString(2, endereco.getCidade());
            st.setString(3, endereco.getBairro());
            st.setString(4, endereco.getRua());
            st.setString(5, endereco.getNumero());
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    endereco.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Cadastro de endereço falhou.");
                }
            }
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir endreco: "+ QUERY_INSERIR + "/ "+ endereco.toString(), e);
        }
    }

    @Override
    public void atualizar(Endereco t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Endereco t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
