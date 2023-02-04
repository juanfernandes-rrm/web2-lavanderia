/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.action.Action;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Peca;
import br.com.tads.model.Pedido;
import br.com.tads.model.status.StatusPedido;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author juann
 */
public class PedidoDAO implements DAO<Pedido>{

    private Connection con = null;

    private static final String QUERY_INSERIR= "INSERT INTO pedido(prazo, valor_total, status_pedido, data_criacao) VALUES (?, ?, ?, ?)";
    private static final String QUERY_INSERIR_ROUPA = "INSERT INTO roupa_pedido(pedido_fk, roupa_fk, qtd_peca) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT numero, prazo, valor_total, status_pedido, data_criacao FROM pedido";
        private static final String QUERY_ATUALIZAR = "UPDATE pedido SET prazo = ?, valor_total = ?, status_pedido = ?, data_criacao = ? WHERE numero = ?";
    
    public PedidoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar PedidoDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Pedido buscar(long id) throws DAOException {
        Pedido pedido = new Pedido();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao FROM pedido WHERE pedido.numero = ?")) {
            stmt.setInt(1, (int) id);
            try (ResultSet rs = stmt.executeQuery()) { 
                if (rs.next()) {
                    pedido.setNumero(rs.getInt("numero"));
                    pedido.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                    pedido.setOrcamento(new Orcamento(BigDecimal.valueOf(rs.getDouble("valor_total")),
                                        rs.getDate("prazo").toLocalDate()));
                    
                    //Achar outra Maneira de fazer isso
                    Class classe = null;
                    try {
                        classe = Class.forName("br.com.tads.model.status."+rs.getString("status_pedido"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    StatusPedido status = (StatusPedido)classe.newInstance();
                    pedido.setStatusPedido(status);
                } else {
                    System.out.println("No object found with id " + id);
                }

              } catch (InstantiationException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        return pedido;
    }
    
    //TODO: esse método
    public List<Pedido> buscarPorStatus(StatusPedido statusPedido) throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao FROM pedido WHERE pedido.status_pedido = ?")) {
            stmt.setString(1, statusPedido.getClass().getSimpleName());
            try (ResultSet rs = stmt.executeQuery()) { 
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumero(rs.getInt("numero"));
                    pedido.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                    pedido.setOrcamento(new Orcamento(BigDecimal.valueOf(rs.getDouble("valor_total")),
                                        rs.getDate("prazo").toLocalDate()));
                    
                    Class classe = null;
                    try {
                        classe = Class.forName("br.com.tads.model.status."+rs.getString("status_pedido"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    StatusPedido status = (StatusPedido)classe.newInstance();
                    pedido.setStatusPedido(status);
                    
                    pedidos.add(pedido);
                }
              } catch (InstantiationException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          } catch (SQLException e) {
              e.printStackTrace();
          }
        return pedidos.stream()
                    .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                    .collect(Collectors.toList());
    }
    
    
    @Override
    public List<Pedido> buscarTodos() throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        try(PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_TODOS);
            ResultSet rs = st.executeQuery()) {
            while(rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                pedido.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                pedido.setOrcamento(new Orcamento(BigDecimal.valueOf(rs.getDouble("valor_total")),
                                    rs.getDate("prazo").toLocalDate()));

                Class classe = null;
                try {
                    classe = Class.forName("br.com.tads.model.status."+rs.getString("status_pedido"));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                StatusPedido status = (StatusPedido)classe.newInstance();
                pedido.setStatusPedido(status);
                pedidos.add(pedido);
            }
            return pedidos.stream()
                    .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                    .collect(Collectors.toList());
        }catch(SQLException e) {
            throw new DAOException("Erro buscando todas as roupas: "+QUERY_BUSCAR_TODOS, e);
        } catch (InstantiationException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void inserir(Pedido pedido) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR, Statement.RETURN_GENERATED_KEYS)){
            st.setDate(1, Date.valueOf(pedido.getOrcamento().getPrazo()));
            st.setDouble(2, pedido.getOrcamento().getValor().doubleValue());
            st.setString(3, pedido.getStatusPedido().getClass().getSimpleName());
            st.setTimestamp(4, Timestamp.valueOf(pedido.getDataCriacao()));
            
            st.executeUpdate();
            
            try (ResultSet generatedKeys = st.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    pedido.setNumero(generatedKeys.getInt(1));
                    inserirPecas(pedido.getNumero(), pedido.getPecas());
                }
                else {
                    throw new SQLException("Criação de pedido falhou.");
                }
            }
            
        }catch(SQLException e) {
            throw new DAOException("Erro ao inserir pedido: "+ QUERY_INSERIR + "/ "+ pedido.toString(), e);
        }
    }

    @Override
    public void atualizar(Pedido pedido) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ATUALIZAR)){
            st.setDate(1, Date.valueOf(pedido.getOrcamento().getPrazo()));
            st.setDouble(2, pedido.getOrcamento().getValor().doubleValue());
            st.setString(3,pedido.getStatusPedido().getClass().getSimpleName());
            st.setTimestamp(4, Timestamp.valueOf(pedido.getDataCriacao()));
            st.setInt(5, pedido.getNumero());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void remover(Pedido t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    private void inserirPecas(int numeroPedido, List<Peca> pecas){
        pecas.stream().forEach(peca -> {
            try(PreparedStatement st = con.prepareStatement(QUERY_INSERIR_ROUPA)){
                st.setInt(1, numeroPedido);
                st.setInt(2, peca.getId());
                st.setInt(3, peca.getQtd());

                st.executeUpdate();
            }catch(SQLException e) {
                e.printStackTrace();
            }
        });   
    }
}
