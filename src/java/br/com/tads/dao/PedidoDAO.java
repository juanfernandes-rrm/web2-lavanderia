/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.tads.dao;

import br.com.tads.action.Action;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Cliente;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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

    private static final String QUERY_INSERIR= "INSERT INTO pedido(prazo, valor_total, status_pedido, data_criacao, cliente_fk) VALUES (?, ?, ?, ?, ?)";
    private static final String QUERY_INSERIR_ROUPA = "INSERT INTO roupa_pedido(pedido_fk, roupa_fk, qtd_peca) VALUES (?, ?, ?)";
    private static final String QUERY_BUSCAR_TODOS= "SELECT numero, prazo, valor_total, status_pedido, data_criacao, cliente_fk FROM pedido";
    private static final String QUERY_ATUALIZAR = "UPDATE pedido SET prazo = ?, valor_total = ?, status_pedido = ?, data_criacao = ? WHERE numero = ?";
    private static final String QUERY_ATUALIZAR_ESTADO = "UPDATE pedido SET status_pedido = ?, WHERE numero = ?";
    private static final String QUERY_BUSCAR_POR_DATA = "SELECT * FROM pedido WHERE data_criacao BETWEEN ? AND ?";
    private static final String QUERY_BUSCAR_POR_DATA_HOJE = "SELECT * FROM pedido WHERE DATE(data_criacao) = ?";
    
    public PedidoDAO(Connection con) throws DAOException{
        if(con== null){
            throw new DAOException("Conexão nula ao criar PedidoDAO.");
        }
        this.con= con;
    }
    
    @Override
    public Pedido buscar(long id) throws DAOException {
        Pedido pedido = new Pedido();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao, cliente_fk FROM pedido WHERE pedido.numero = ?")) {
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
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
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
    
    //Pedidos de todo os clientes (Para Funcionários)
    public List<Pedido> buscarPorStatus(StatusPedido statusPedido) throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao, cliente_fk FROM pedido WHERE pedido.status_pedido = ?")) {
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
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
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
    
    public List<Pedido> buscarPorStatus(StatusPedido statusPedido, int idCliente) throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao, cliente_fk FROM pedido WHERE pedido.status_pedido = ? AND pedido.cliente_fk = ?")) {
            stmt.setString(1, statusPedido.getClass().getSimpleName());
            stmt.setInt(2, idCliente);
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
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
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
                pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
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

    public List<Pedido> buscarTodos(int idCliente) throws DAOException, SQLException {
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement stmt = con.prepareStatement("SELECT numero, prazo, valor_total, status_pedido, data_criacao, cliente_fk FROM pedido WHERE pedido.cliente_fk = ?")) {
            stmt.setInt(1, idCliente);
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
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
                    
                    pedidos.add(pedido);
                }
                return pedidos;
            } catch (InstantiationException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
          } catch (SQLException e) {
              e.printStackTrace();
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
            st.setInt(5, pedido.getCliente().getId());
            
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

    private Cliente buscaCliente(int id) throws DAOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO(con);
        return (Cliente) usuarioDAO.buscarCliente(id);
    }
    
    public void atualizarEstado(Pedido pedido, String estado) throws DAOException {
        try(PreparedStatement st = con.prepareStatement(QUERY_ATUALIZAR_ESTADO)){
            st.setString(1, estado);
            st.setInt(2, pedido.getNumero());
            
            st.executeUpdate();
        
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Pedido> buscarPedidosDeHoje() throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        LocalDate hoje = LocalDate.now();

        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_DATA_HOJE)) {
            st.setDate(1, Date.valueOf(hoje));

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumero(rs.getInt("numero"));
                    pedido.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                    pedido.setOrcamento(new Orcamento(BigDecimal.valueOf(rs.getDouble("valor_total")),
                            rs.getDate("prazo").toLocalDate()));

                    Class classe = null;
                    try {
                        classe = Class.forName("br.com.tads.model.status." + rs.getString("status_pedido"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    StatusPedido status = (StatusPedido) classe.newInstance();
                    pedido.setStatusPedido(status);
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
                    pedidos.add(pedido);
                }
                return pedidos.stream()
                        .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                        .collect(Collectors.toList());
            } catch (SQLException e) {
                throw new DAOException("Erro buscando todas as roupas: " + QUERY_BUSCAR_POR_DATA_HOJE, e);
            } catch (InstantiationException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todas as roupas: " + QUERY_BUSCAR_POR_DATA_HOJE, e);
        }
        return null;
    }

    public List<Pedido> buscarPedidosPorData(Date ini, Date fin) throws DAOException {
        List<Pedido> pedidos = new ArrayList<>();
        try (PreparedStatement st = con.prepareStatement(QUERY_BUSCAR_POR_DATA)) {
            st.setTimestamp(1, new Timestamp(ini.getTime()));
            st.setTimestamp(2, new Timestamp(fin.getTime()));

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setNumero(rs.getInt("numero"));
                    pedido.setDataCriacao(rs.getTimestamp("data_criacao").toLocalDateTime());
                    pedido.setOrcamento(new Orcamento(BigDecimal.valueOf(rs.getDouble("valor_total")),
                            rs.getDate("prazo").toLocalDate()));

                    Class classe = null;
                    try {
                        classe = Class.forName("br.com.tads.model.status." + rs.getString("status_pedido"));
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    StatusPedido status = (StatusPedido) classe.newInstance();
                    pedido.setStatusPedido(status);
                    pedido.setCliente(buscaCliente(rs.getInt("cliente_fk")));
                    pedidos.add(pedido);
                }
                return pedidos.stream()
                        .sorted(Comparator.comparing(Pedido::getDataCriacao).reversed())
                        .collect(Collectors.toList());
            } catch (SQLException e) {
                throw new DAOException("Error searching for all orders: " + QUERY_BUSCAR_POR_DATA, e);
            } catch (InstantiationException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException e) {
            throw new DAOException("Error creating prepared statement: " + QUERY_BUSCAR_POR_DATA, e);
        }
        return null;
    }

    public Pedido buscarPedidosPorData(java.util.Date iniData, java.util.Date fimData) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
