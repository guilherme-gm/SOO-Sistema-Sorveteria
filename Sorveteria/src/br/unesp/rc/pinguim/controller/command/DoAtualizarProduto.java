package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

/**
 * Realiza a inser��o de um produto
 *
 */
@Command(url = "/DoAtualizarProduto")
public class DoAtualizarProduto implements ICommand {

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO : Falta as oper�a�es de atualizar
//		Produto produto = new Produto();
//		produto.setCodigo(Long.parseLong(request.getParameter("codigo")));
//		produto.setNome(request.getParameter("nome"));
//		produto.setCategoria(CategoriaProduto.valueOf(request.getParameter("categoria")));
//		produto.setEstoqueMinimo(Integer.parseInt(request.getParameter("estoqueMinimo")));
//		produto.setPrecoCompra(Double.parseDouble(request.getParameter("precoCompra")));
//		produto.setPrecoVenda(Double.parseDouble(request.getParameter("precoVenda")));
//
//		ProdutoService ps = ServiceFactory.getProdutoService();
//		boolean b = ps.(produto);
		boolean b = false;
		CommandResult rs = null;
		if (b) {
			rs = new CommandResult("/home", true);
		} else {
			rs = new CommandResult("produto/inserir");
		}

		return rs;
	}

}
