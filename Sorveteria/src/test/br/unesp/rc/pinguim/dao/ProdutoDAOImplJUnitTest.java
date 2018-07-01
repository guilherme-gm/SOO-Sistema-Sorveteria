package test.br.unesp.rc.pinguim.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unesp.rc.pinguim.dao.ProdutoDAOImpl;
import br.unesp.rc.pinguim.models.Produto;

class ProdutoDAOImplJUnitTest  {

	@Test
	void buscarPorCodigo() {
		
		@SuppressWarnings("unused")
		ProdutoDAOImpl  p = new ProdutoDAOImpl();
		
		
		//System.out.println(p.buscarPorCodigo(1));
	}
	
	@Test
	void buscaPorNome() {
		@SuppressWarnings("unused")
		ProdutoDAOImpl p = new ProdutoDAOImpl();
		//System.out.println(p.BuscarPorNome("Morango"));
	}
	
	@Test
	void buscaTodos() {
		ProdutoDAOImpl p = new ProdutoDAOImpl();
		List<Produto> produtos = p.BuscarTodos();
		for(Produto prod : produtos) {
			System.out.println(prod);
		}
		
	}
	
	@Test
	void atualizarProduto() {
		ProdutoDAOImpl p = new ProdutoDAOImpl();
		Produto prod = p.buscarPorCodigo(1);
		prod.setNome("Chocolate com menta");
		p.AtualizarProduto(prod);
		prod = p.buscarPorCodigo(1);
		
		System.out.println(prod);
		
	}
	

}
