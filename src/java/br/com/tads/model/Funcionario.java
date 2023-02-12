package br.com.tads.model;

public class Funcionario extends Usuario{

    public Funcionario() {
    }
    
    public Funcionario(String cpf, String nome, String email, br.com.tads.model.Endereco Endereco, String telefone, String senha) {
        super(cpf, nome, email, Endereco, telefone, senha);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public br.com.tads.model.Endereco getEndereco() {
        return Endereco;
    }

    @Override
    public String getTelefone() {
        return telefone;
    }

    @Override
    public String getSenha() {
        return senha;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setEndereco(br.com.tads.model.Endereco Endereco) {
        this.Endereco = Endereco;
    }

    @Override
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
