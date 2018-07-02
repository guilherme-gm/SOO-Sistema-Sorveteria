package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.VendaDAO;
import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Produto;
import br.unesp.rc.pinguim.models.Venda;

/**
 * Service com ações relacionadas a uma Venda
 */
public class VendaServiceImpl implements VendaService {

	private VendaDAO vendaDAO;

	/**
	 * Inicializa o Service e cria uma instância da DAO usada.
	 */
	public VendaServiceImpl() {
		this.vendaDAO = DAOFactory.getVendaDAO();
	}

	/**
	 * Salva uma venda
	 * 
	 * @param venda
	 *            : venda a ser salva
	 * @return <code>true</code> se salvou com sucesso. <code>false</code> caso
	 *         contrário.
	 */
	@Override
	public boolean salvar(Venda venda) {
		boolean b = false;
		boolean estoque = true;

		ProdutoService ps = ServiceFactory.getProdutoService();

		for (ItemVenda item : venda.getItens()) {
			if (item.getQuantidade() > item.getProduto().getQuantidadeEstoque()) {
				estoque = false;
			}

			Produto p = item.getProduto();
			p.setQuantidadeEstoque(p.getQuantidadeEstoque() - item.getQuantidade());
			ps.atualizar(p);
		}

		if (estoque) {
			b = this.vendaDAO.salvar(venda);
		}

		return b;
	}

	/**
	 * Busca todas a vendas
	 *
	 * @return Retorna todas as vendas
	 */
	@Override
	public List<Venda> buscarTodos() {
		return this.vendaDAO.BuscarTodos();
	}

	/**
	 * Calcula o total da venda
	 * 
	 * @param itens
	 *            : lista de itens presentes na venda
	 * @return Total da venda
	 */
	@Override
	public Double CalculaTotal(List<ItemVenda> itens) {
		Double total = 0.0;
		for (ItemVenda item : itens) {
			total += item.getQuantidade() * item.getValorUnidade();
		}

		return total;
	}

}
