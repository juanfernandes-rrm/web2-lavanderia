/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.EnderecoDAO;
import br.com.tads.dao.FuncionarioDAO;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Endereco;
import br.com.tads.model.Funcionario;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class AtualizarFuncionario implements Action {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try(ConnectionFactory factory = new ConnectionFactory()){
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String telefone = request.getParameter("telefone");
        String senha = request.getParameter("senha");
        String idString = request.getParameter("id");
        String idEndereco = request.getParameter("endereco");
                
        Endereco endereco = new Endereco(estado,cidade, bairro, rua, numero);
        Funcionario funcionario = new Funcionario(cpf, nome, email, endereco, telefone, senha);
        
        if (idString != null) {
            try {
                int id = Integer.parseInt(idString);
                funcionario.setId(id);
            } catch (NumberFormatException e) {
                request.setAttribute("mensagem", "Erro ao selecionar Funcionário");
                return "forward:manterFuncionario.jsp";
            }
        }
        
        if (idEndereco != null) {
            try {
                int id = Integer.parseInt(idEndereco);
                endereco.setId(id);
            } catch (NumberFormatException e) {
                request.setAttribute("mensagem", "Erro ao selecionar Funcionário");
                return "forward:manterFuncionario.jsp";
            }
        }
        
        EnderecoDAO enderecoDAO = new EnderecoDAO(factory.getConnection());
        enderecoDAO.atualizar(endereco);
        
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO(factory.getConnection());
        funcionarioDAO.atualizar(funcionario);
        request.setAttribute("mensagem", "Funcionário atualizado");
            
        } catch (Exception ex) {
            request.setAttribute("mensagem", ex.getMessage());
        }
        
        return "forward:manterFuncionario.jsp";
    }
}
