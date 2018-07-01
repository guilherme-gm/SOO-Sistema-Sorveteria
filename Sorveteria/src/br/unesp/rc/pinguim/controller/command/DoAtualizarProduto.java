package br.unesp.rc.pinguim.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unesp.rc.pinguim.models.CategoriaProduto;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.service.ProdutoService;
import br.unesp.rc.pinguim.service.ServiceFactory;

@Command(url = "/DoAtualizarProduto")
public class DoAtualizarProduto implements ICommand{

	@Override
	public CommandResult execute(HttpServletRequest request, HttpServletResponse response) {
		Produto produto = new Produto();		
		produto.setCodigo(Long.parseLong(request.getParameter("codigo")));
		produto.setNome(request.getParameter("nome"));
		produto.setCategoria(CategoriaProduto.valueOf(request.getParameter("categoria")));
		produto.setQuantidadeEstoque(Integer.parseInt(request.getParameter("quantidadeEstoque")));
		produto.setEstoqueMinimo(Integer.parseInt(request.getParameter("estoqueMinimo")));
		produto.setPrecoCompra(Double.parseDouble(request.getParameter("precoCompra")));
		produto.setPrecoVenda(Double.parseDouble(request.getParameter("precoVenda")));
		
		ProdutoService ps = ServiceFactory.getProdutoService();
		boolean b = ps.atualizar(produto);
		
		CommandResult  rs = null;
		if(b) {
			rs =  new CommandResult("ListarProdutos", true);
		}else {
			rs = new CommandResult("produto/atualizar");
		}
		return rs;
	}

	
}

