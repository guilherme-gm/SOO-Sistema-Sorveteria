package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.models.ItemVenda;
import br.unesp.rc.pinguim.models.Venda;

/**
 * Service para manipulação da classe Venda
 */
public interface VendaService {

	/**
	 * Salva uma Venda no banco.
	 * 
	 * @param venda
	 *            : Venda a ser salva
	 * @return <code>true</code> se salvou com sucesso. <code>false</code> caso
	 *         contrário.
	 */
	public boolean salvar(Venda venda);

	/**
	 * Busca todas as vendas
	 *
	 * @return Retorna todas as vendas
	 */
	public List<Venda> buscarTodos();

	/**
	 * Calcula o total da venda
	 * 
	 * @param venda
	 *            : venda na qual o total será calculado
	 * @return retorna o total da venda
	 */
	public double calculaTotal(List<ItemVenda> venda);

}
