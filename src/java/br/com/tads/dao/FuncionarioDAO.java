/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Endereco;
import br.com.tads.model.Funcionario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Felipe
 */
public class FuncionarioDAO implements DAO<Funcionario>{
  
    private Connection con = null;
    private static final String QUERY_BUSCAR_FUNCIONARIO = "SELECT * FROM usuario WHERE iscliente = 'false'";
    private static final String QUERY_EXCLUIR_FUNCIONARIO = "DELETE FROM usuario WHERE id = ?"; 
    private static final String QUERY_UPDATE = "UPDATE usuario SET cpf = ?, nome = ?, email = ?, endereco_fk = ?, telefone = ? WHERE id = ?";
    
    public FuncionarioDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar PessoaDAO.");
        }
        this.con= con;
    }

    @Override
    public Funcionario buscar(long id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Funcionario> buscarTodos() throws DAOException {
        List<Funcionario> funcionarios = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement(QUERY_BUSCAR_FUNCIONARIO)) {
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Funcionario usuario = new Funcionario();
                    usuario.setId(rs.getInt("id"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setEndereco(buscaEndereco(rs.getInt("endereco_fk")));
                    usuario.setTelefone(rs.getString("telefone"));
                    usuario.setSenha(rs.getString("senha"));
                    funcionarios.add(usuario);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return funcionarios;
    }

    @Override
    public void inserir(Funcionario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void atualizar(Funcionario t) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_UPDATE)){
            st.setString(1, t.getCpf());
            st.setString(2, t.getNome());
            st.setString(3, t.getEmail());
            st.setInt(4, t.getEndereco().getId());
            st.setString(5, t.getTelefone());
            st.setInt(6, t.getId());
            
            st.executeUpdate();
            
        }catch (SQLException e) {
            if (e.getSQLState().equals("23505")) {
                throw new DAOException("E-mail já existe");
            } else {
               throw new DAOException("Erro ao atualizar usuário: "+ t.getId(), e);
            }
        }
    }

    @Override
    public void remover(Funcionario t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void excluirFuncionario(int id) throws DAOException {
        try (PreparedStatement stmt = con.prepareStatement(QUERY_EXCLUIR_FUNCIONARIO)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro ao cadastrar usuário: "+ id, e);
        }
    }
    
    private Endereco buscaEndereco(int id) throws DAOException {
        EnderecoDAO enderecoDAO = new EnderecoDAO(con);
        return enderecoDAO.buscar(id);
    }
    
}
