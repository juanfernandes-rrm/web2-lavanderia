package br.com.tads.model;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario{
    private List<Pedido> pedidos = new ArrayList<>();
    
    public Cliente(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }
    
    
    
}
