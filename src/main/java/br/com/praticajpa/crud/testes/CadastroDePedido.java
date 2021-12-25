package br.com.praticajpa.crud.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.praticajpa.crud.dao.ClienteDAO;
import br.com.praticajpa.crud.dao.PedidoDAO;
import br.com.praticajpa.crud.dao.ProdutoDAO;
import br.com.praticajpa.crud.modelo.Cliente;
import br.com.praticajpa.crud.modelo.ItemPedido;
import br.com.praticajpa.crud.modelo.Pedido;
import br.com.praticajpa.crud.modelo.Produto;
import br.com.praticajpa.crud.unit.JPAUtil;
import br.com.praticajpa.crud.vo.RelatorioDeVendasVo;

public class CadastroDePedido {

	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
	//	Produto produto = produtoDAO.buscarPorId(3l);
		Cliente cliente = clienteDAO.buscarPorId(1l);
		
		Produto produto2 = produtoDAO.buscarPorId(13l);
		Produto produto3 = produtoDAO.buscarPorId(14l);
		
		em.getTransaction().begin();
		
	
	//	Pedido pedido = new Pedido(cliente);
	//	pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		Pedido pedido2 = new Pedido(cliente);
		Pedido pedido3 = new Pedido(cliente);
		
		pedido2.adicionarItem(new ItemPedido(5, pedido2, produto2));
		pedido3.adicionarItem(new ItemPedido(2, pedido3, produto3));
		
		PedidoDAO pedidoDAO = new PedidoDAO(em);
	//	pedidoDAO.cadastrar(pedido);
		pedidoDAO.cadastrar(pedido2);
		pedidoDAO.cadastrar(pedido3);
		
		em.getTransaction();
		
		
		
		BigDecimal totalVendido = pedidoDAO.valorTotalVendido();
		System.out.println("VALOR TOTAL VENDIDO: " + totalVendido);
		
		List<RelatorioDeVendasVo> relatorio = pedidoDAO.relatorioDeVendas();
		relatorio.forEach(System.out::println);
		
		
	}

}
