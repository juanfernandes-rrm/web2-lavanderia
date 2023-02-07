package br.com.tads;

import br.com.tads.exceptions.DAOException;
import br.com.tads.model.utils.RandomPassword;
import br.com.tads.sendmail.Mail;

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

            
//            EnderecoDAO enderecoDAO = new EnderecoDAO(conn);
//            enderecoDAO.inserir(endereco);
//            cliente.setEndereco(endereco);
//            ClienteDAO clienteDAO = new ClienteDAO(conn);
//            clienteDAO.inserir(cliente);

//              Roupa roupa = new Roupa("CAMISETA",5.0,2);
//                try(ConnectionFactory factory = new ConnectionFactory()){
//                    Connection conn = factory.getConnection();
//                    RoupaDAO roupaDAO = new RoupaDAO(conn);
//                    Roupa roupa = roupaDAO.buscar(2);
//                    Peca peca = new Peca(roupa, 3);
//                    
//                    Orcamento orcamento = new Orcamento();
//                    orcamento.setPrazo(LocalDate.now().plusDays(roupa.getPrazoEntrega()));
//                    orcamento.somaValor(BigDecimal.valueOf(roupa.getValor()).multiply(BigDecimal.valueOf(3)));
//                    
//                    Pedido pedido = new Pedido();
//                    pedido.setOrcamento(orcamento);
//                    pedido.adicionarPeca(peca);
//                    
//                    PedidoDAO pedidoDAO = new PedidoDAO(conn);
//                    pedidoDAO.inserir(pedido);
//                    System.out.println("Class: "+pedido.getStatusPedido().getClass().getName());
//                    System.out.println("Class: "+pedido.getStatusPedido().getClass().getSimpleName());
//                    System.out.println("Class: "+pedido.getStatusPedido().getClass().getCanonicalName());
//                    
//                    System.out.println("Lista: "+pedidoDAO.buscarPorStatus(new EmAnalise()));
//                } catch (SQLException ex) {
//                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (Exception ex) {
//                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
//                }
               
//              roupaDAO.inserir(roupa);
//              
//              Orcamento orcamento = new Orcamento();
//              orcamento.setPrazo(LocalDate.now().plusDays(roupa.getPrazoEntrega()));
//              orcamento.somaValor(BigDecimal.valueOf(roupa.getValor()));
//              
//              Pedido pedido = new Pedido();
//              pedido.setOrcamento(orcamento);
//              PedidoDAO pedidoDAO = new PedidoDAO(conn);
//              pedidoDAO.inserir(pedido);
//              
//              RoupaPedido roupaPedido = new RoupaPedido();
//              roupaPedido.setPedido(pedido);
//              roupaPedido.setRoupa(roupa);
//              roupaPedido.setQtd(3);
//              RoupaPedidoDAO roupaPedidoDAO = new RoupaPedidoDAO(conn);
//              roupaPedidoDAO.inserirRoupaPedido(roupaPedido);
//              
//              List<Roupa> roupas = roupaDAO.buscarTodos();
//              roupas.stream().forEach(r -> {
//                  System.out.println(r.getPeca());
//              });

    Mail mail = new Mail("juanfernandesrrm@gmail.com","Titulo",RandomPassword.generateRandomPassword(25));
    mail.send();
        
        
    }
}
