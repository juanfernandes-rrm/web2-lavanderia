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

    private static final String QUERY_INSERIR= "INSERT INTO endereco(cidade, estado) VALUES (?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT id, cidade, estado FROM endereco";
    
    public EnderecoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar EnderecoDAO.");
        }
        this.con= con;
    }
    @Override
    public Endereco buscar(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Endereco> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Endereco endereco) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, endereco.getCidade());
            st.setString(2, endereco.getEstado());
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    endereco.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Criação de endereço falhou.");
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
