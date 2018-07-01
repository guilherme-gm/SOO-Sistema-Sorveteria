package br.unesp.rc.pinguim.controller.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.models.Funcionario;
import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Pagamento;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.models.Venda;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;
import br.unesp.rc.pinguim.service.VendaService;

public class DoInserirVenda implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {

		Venda venda = new Venda();

		venda.setDataVenda(new java.util.Date());
		venda.setTotal(Double.parseDouble(request.getParameter("total")));
		// TO DO: pegar o funcionario da session
		Funcionario func = new Funcionario();
		func.setCodigo(1);
		venda.setVendedor(func);

		/* Carrega os produtos e a quantidade */
		String[] produtos = request.getParameterValues("produto");
		String[] quantidades = request.getParameterValues("quantidade");
		if (produtos == null || quantidades == null) {
			// throw new Exception();
		}

		/* Converte os produtos e a quantidade para long e int */
		long[] produtosIds = new long[produtos.length];
		int[] valorQuantidade = new int[quantidades.length];
		for (int i = 0; i < produtos.length; ++i) {
			try {
				produtosIds[i] = Long.parseLong(produtos[i]);
				valorQuantidade[i] = Integer.parseInt(quantidades[i]);
			} catch (Exception ex) {
				System.out.println("Erro no parser: " + ex.getMessage());
				// throw new Exception();
			}
		}
		/* Cria a lista de itemVenda com os produtos buscados pelos ids */
		List<ItemVenda> itens = new ArrayList();
		ProdutoService ps = ServiceFactory.getProdutoService();
		for (int i = 0; i < produtosIds.length; i++) {
			Produto produto = ps.buscar(produtosIds[i]);
			itens.add(new ItemVenda(valorQuantidade[i], produto.getPrecoVenda(), produto));

		}
		venda.setItens(itens);

		/*Carrega o metodo do pagamento*/
		Pagamento pagamento = new Pagamento(request.getParameter("metodoPagamento")); 
		venda.setPagamento(pagamento);
		
		HttpSession session = request.getSession();

		session.setAttribute("venda", venda);

		return new CommandResult("RegistrarPagamento", true);
	}

}
