package br.com.tads;

import java.sql.Connection;
import br.com.tads.connection.ConnectionFactory;
import br.com.tads.dao.PedidoDAO;
import br.com.tads.dao.RoupaDAO;
import br.com.tads.dao.RoupaPedidoDAO;
import br.com.tads.exceptions.DAOException;
import br.com.tads.model.Orcamento;
import br.com.tads.model.Pedido;
import br.com.tads.model.Roupa;
import br.com.tads.model.RoupaPedido;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) throws DAOException {
//        Pedido pedido = new Pedido();
//        System.out.println(pedido.getDataCriacao());
//        System.out.println(pedido.getStatusPedido());
//        pedido.aprovar();
//        System.out.println(pedido.getStatusPedido());
//        BancoDeDados.adicionarPedido(pedido);
//        
//        System.out.println("pedidos: "+BancoDeDados.getPedidoPorStatus(new EmAberto()));

//            Cliente cliente = new Cliente("Juan", "123");
//            cliente.setCpf("12872189971");
//            cliente.setEmail("Juan@email.com");
//            cliente.setTelefone("123456789");
//            Endereco endereco = new Endereco();
//            endereco.setCidade("Pinhais");
//            endereco.setEstado("Paraná");

            Connection conn = ConnectionFactory.getConnection();
//            EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
//            enderecoDAO.inserir(endereco);
//            cliente.setEndereco(endereco);
//            ClienteDAO clienteDAO = new ClienteDAO(conn);
//            clienteDAO.inserir(cliente);

              Roupa roupa = new Roupa("CAMISETA",5.0,2);
              RoupaDAO roupaDAO = new RoupaDAO(conn);
              roupaDAO.inserir(roupa);
              
              Orcamento orcamento = new Orcamento();
              orcamento.setPrazo(LocalDate.now().plusDays(roupa.getPrazoEntrega()));
              orcamento.somaValor(BigDecimal.valueOf(roupa.getValor()));
              
              Pedido pedido = new Pedido();
              pedido.setOrcamento(orcamento);
              PedidoDAO pedidoDAO = new PedidoDAO(conn);
              pedidoDAO.inserir(pedido);
              
              RoupaPedido roupaPedido = new RoupaPedido();
              roupaPedido.setPedido(pedido);
              roupaPedido.setRoupa(roupa);
              roupaPedido.setQtd(3);
              RoupaPedidoDAO roupaPedidoDAO = new RoupaPedidoDAO(conn);
              roupaPedidoDAO.inserirRoupaPedido(roupaPedido);
              
              List<Roupa> roupas = roupaDAO.buscarTodos();
              roupas.stream().forEach(r -> {
                  System.out.println(r.getPeca());
              });
    }
}
