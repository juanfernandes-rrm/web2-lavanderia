package br.com.tads.action;

import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.EnderecoDAO;
import br.com.tads.dao.UsuarioDAO;
import br.com.tads.model.Endereco;
import br.com.tads.model.Funcionario;
import br.com.tads.model.Usuario;
import java.sql.Connection;
import br.com.tads.model.utils.RandomPassword;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juann
 */
public class CadastroFuncionario implements Action{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cpf = request.getParameter("cpf");
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String estado = request.getParameter("estado");
        String cidade = request.getParameter("cidade");
        String bairro = request.getParameter("bairro");
        String rua = request.getParameter("rua");
        String numero = request.getParameter("numero");
        String telefone = request.getParameter("telefone");
        
        System.out.println("Email: "+email);
        
        String senha = "Sua senha temporária é: "+RandomPassword.generateRandomPassword(25);
//        SendMail.send(email,"Lavanderia Online - Sua senha ",senha);
        
        Endereco endereco = new Endereco(estado,cidade, bairro, rua, numero);
        Usuario usuario = new Funcionario(cpf, nome, email, endereco, telefone, senha);

        try(ConnectionFactory factory = new ConnectionFactory()){
            Connection con = factory.getConnection();
            
            EnderecoDAO enderecoDAO = new EnderecoDAO(con);
            enderecoDAO.inserir(endereco);
            
            UsuarioDAO usuarioDAO = new UsuarioDAO(con);
            usuarioDAO.inserir(usuario);
            
          } catch (Exception ex) {
            Logger.getLogger(Cadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return "forward:login.jsp";
    }  
}
