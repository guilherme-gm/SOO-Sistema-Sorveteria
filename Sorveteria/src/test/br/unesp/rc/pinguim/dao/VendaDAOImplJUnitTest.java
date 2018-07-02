package test.br.unesp.rc.pinguim.dao;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.unesp.rc.pinguim.dao.VendaDAOImpl;
import br.unesp.rc.pinguim.models.Venda;

class VendaDAOImplJUnitTest {

	@Test
	void inserir() {
		// ProdutoDAOImpl p = new ProdutoDAOImpl();
		// Venda venda = new Venda();
		// Funcionario vendedor = new Funcionario();
		// vendedor.setCodigo(1);
		//
		// venda.setVendedor(vendedor);
		// venda.setDataVenda(new java.util.Date());
		// venda.setTotal(30.9);
		//
		// List<ItemVenda> itens = new ArrayList();
		// Produto produto = p.buscarPorCodigo(1);
		// itens.add(new ItemVenda(3,2.5,produto));
		//
		// produto = p.buscarPorCodigo(2);
		// itens.add(new ItemVenda(5,1.5,produto));
		//
		// venda.setItens(itens);
		//
		// Pagamento pag = new Pagamento("dinheiro");
		//
		// venda.setPagamento(pag);
		//
		// VendaDAOImpl v = new VendaDAOImpl();
		// System.out.println(v.salvar(venda));

	}

	@Test
	void busca() {
		VendaDAOImpl v = new VendaDAOImpl();
		List<Venda> vendas = v.buscarTodos();
		int i = 0;
		for (Venda venda : vendas) {
			System.out.println(i++);
			System.out.println(venda);
		}
	}

}
