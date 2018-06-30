package test.br.unesp.rc.pinguim.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unesp.rc.pinguim.dao.ProdutoDAOImpl;
import br.unesp.rc.pinguim.models.Produto;

class ProdutoDAOImplJUnitTest  {

	@Test
	void buscarPorCodigo() {
		
		ProdutoDAOImpl  p = new ProdutoDAOImpl();
		
		
		//System.out.println(p.buscarPorCodigo(1));
	}
	
	@Test
	void buscaPorNome() {
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
	
	

}
