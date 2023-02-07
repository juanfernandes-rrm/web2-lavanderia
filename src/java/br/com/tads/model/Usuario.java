package br.com.tads.model;

public abstract class Usuario {
    protected int id;
    protected String cpf;
    protected String nome;
    protected String email;
    protected Endereco Endereco;
    protected String telefone;
    protected String senha;

    public Usuario() {
    }
    
    public Usuario(String cpf, String nome, String email, Endereco Endereco, String telefone, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.Endereco = Endereco;
        this.telefone = telefone;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
