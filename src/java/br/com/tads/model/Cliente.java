package br.com.tads.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(){};
    
    public Cliente(String cpf, String nome, String email, Endereco endereco, String telefone, String senha) {
        super(cpf, nome, email, endereco, telefone, senha);
    }

    
    
}
