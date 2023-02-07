package br.com.tads.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    
    public Cliente(){};
    
    public Cliente(String cpf, String nome, String email, Endereco endereco, String telefone, String senha) {
        super(cpf, nome, email, endereco, telefone, senha);
    }

    
    
}
