package br.com.tads.model;

import java.util.ArrayList;

public class Funcionario extends Usuario{
    private String email;
    private String nome;
    private String nascimento;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(String email, String nome, String nascimento, String senha) {
        this.email = email;
        this.nome = nome;
        this.nascimento = nascimento;
        this.senha = senha;
    }
    
    public ArrayList listaFuncionario(){
        ArrayList<Funcionario> listaFunc = new ArrayList<Funcionario>();
        Funcionario f1 = new Funcionario("maria@funcionario.com.br","Maria","29/02/2002","maria");
        Funcionario f2 = new Funcionario("mario@funcionario.com.br","Mário","02/02/2002","mario");
        listaFunc.add(f1);
        listaFunc.add(f2);

        return listaFunc;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    } 
}
