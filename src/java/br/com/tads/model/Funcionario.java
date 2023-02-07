package br.com.tads.model;

public class Funcionario extends Usuario{

    public Funcionario() {
    }
    
    public Funcionario(String cpf, String nome, String email, br.com.tads.model.Endereco Endereco, String telefone, String senha) {
        super(cpf, nome, email, Endereco, telefone, senha);
    }
}
