/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Cliente;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author juann
 */
public class ClienteDAO implements DAO<Cliente>{
    
    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO users(cpf, nome, email, endereco_fk, telefone, senha) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT id, cpf, nome, email, endereco_fk, telefone, senha FROM users";
    
    public ClienteDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Cliente buscar(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cliente> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Cliente cliente) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR)){
            st.setString(1, cliente.getCpf());
            st.setString(2, cliente.getNome());
            st.setString(3, cliente.getEmail());
            st.setInt(4, cliente.getEndereco().getId());
            st.setString(5, cliente.getTelefone());
            st.setString(6, cliente.getSenha());
            
            st.executeUpdate();
        }catch(SQLException e) {
            throw new DAOException("Erroinserindopessoa: "+ QUERY_INSERIR + "/ "+ cliente.toString(), e);
        }
    }

    @Override
    public void atualizar(Cliente t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Cliente t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
