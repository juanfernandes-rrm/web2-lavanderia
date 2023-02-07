/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Cliente;
import br.com.tads.model.Endereco;
import br.com.tads.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author juann
 */
public class UsuarioDAO implements DAO<Usuario>{

    private Connection con;
    
    private static final String QUERY_INSERIR= "INSERT INTO usuario(cpf, nome, email, endereco_fk, telefone, senha) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR= "SELECT id, cpf, nome, email, endereco_fk, telefone, senha FROM usuario "
                                                + "WHERE usuario.email = ? AND usuario.senha = ?";
    
    public UsuarioDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar RoupaDAO.");
        }
        this.con= con;
    }
    
    public Usuario buscarCliente(String login, String senha) throws DAOException {
        Usuario usuario = new Cliente();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR)) {
            stmt.setString(1, login);
            stmt.setString(2, senha);
            try (ResultSet rs = stmt.executeQuery()) { 
                if (rs.next()) {
                    usuario.setId(rs.getInt("id"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setEndereco(buscaEndereco(rs.getInt("endereco_fk")));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setSenha(rs.getString("senha"));
                    return usuario;
                } else {
                    System.out.println("No object found" );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @Override
    public Usuario buscar(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Usuario> buscarTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void inserir(Usuario usuario) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setString(1, usuario.getCpf());
            st.setString(2, usuario.getNome());
            st.setString(3, usuario.getEmail());
            st.setInt(4, usuario.getEndereco().getId());
            st.setString(5, usuario.getTelefone());
            st.setString(6, usuario.getSenha());
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    usuario.setId(generatedKeys.getInt(1));
                }
                else {
                    throw new SQLException("Cadastro de usuário falhou.");
                }
            }
        }catch(SQLException e) {
            throw new DAOException("Erro ao cadastrar usuário: "+ QUERY_INSERIR + "/ "+ usuario.toString(), e);
        }
    }

    @Override
    public void atualizar(Usuario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remover(Usuario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private Endereco buscaEndereco(int id) throws DAOException {
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        return enderecoDAO.buscar(id);
    }
    
}
