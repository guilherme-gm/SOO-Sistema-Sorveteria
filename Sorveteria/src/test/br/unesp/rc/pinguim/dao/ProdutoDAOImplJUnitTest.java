package test.br.unesp.rc.pinguim.dao;

import org.junit.jupiter.api.Test;

import br.unesp.rc.pinguim.dao.ProdutoDAOImpl;

class ProdutoDAOImplJUnitTest  {

	@Test
	void buscarPorCodigo() {
		
		ProdutoDAOImpl  p = new ProdutoDAOImpl();
		
		
		System.out.println(p.buscarPorCodigo(1));
	}

}
