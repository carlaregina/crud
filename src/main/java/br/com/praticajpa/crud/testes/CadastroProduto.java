package br.com.praticajpa.crud.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.praticajpa.crud.dao.CategoriaDAO;
import br.com.praticajpa.crud.dao.ClienteDAO;
import br.com.praticajpa.crud.dao.ProdutoDAO;
import br.com.praticajpa.crud.modelo.Categoria;
import br.com.praticajpa.crud.modelo.Cliente;
import br.com.praticajpa.crud.modelo.Produto;
import br.com.praticajpa.crud.unit.JPAUtil;

public class CadastroProduto {
	
	public static void main(String[] args) {
		
	    cadastrarproduto();
	    
	    Long id = 3l;
	    
	    EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Produto p = produtoDAO.buscarPorId(id);
	    System.out.println(p.getPreco());
	    
	    List<Produto> todos = produtoDAO.buscarTodos();
	    todos.forEach(p2 -> System.out.println(p2.getNome()));
	}

	private static void cadastrarproduto() {
		//Categoria celulares = new Categoria("celulares");
		//Produto celular = new Produto("Xiaomi Redmi", "muito legal", new BigDecimal("800"),celulares);
	//	Cliente cliente = new Cliente("Carla", "654654987");
		Categoria videogames = new Categoria("videogames");
		Categoria informatica = new Categoria("informatica");
		
		Produto videogame = new Produto("PS5", "Playstation 5", new BigDecimal("5000"), videogames);
		Produto macbook = new Produto("Macbook", "Macbook pro", new BigDecimal("13000"), informatica);
		
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
	//	ClienteDAO clienteDao = new ClienteDAO(em);
		
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(videogames);
		categoriaDAO.cadastrar(informatica);
		produtoDAO.cadastrar(videogame);
		produtoDAO.cadastrar(macbook);
		//clienteDao.cadastrar(cliente);
		em.getTransaction();
		em.close();
	}
}


