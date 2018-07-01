package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.models.Produto;

/**
 * Service para manipulação da classe Produto
 */
public interface ProdutoService {

    /**
     * Salva um Produto no banco.
     * @param  produto :  Produto a ser salvo
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrário.
     */
    public boolean salvar(Produto produto);

    /**
     * Busca um Produto a partir de seu código.
     *
     * @param codigo : código do Produto
     * @return Produto com o código correspondente ou <code>null</code> se não encontrado.
     */
    public Produto buscar(long codigo);
    
    /**
     * Busca produtos a partir do seu nome
     * @param nome :  nome do Produto
     * @return Produto com o nome correspondente ou <code>null</code> se não encontrado.
     */
    public List<Produto> buscar(String nome);

    /**
     * Busca todos os produtos
     * @return Uma lista de produtos
     */
	public List<Produto> buscarTodos();

	/**
	 * Atualiza um determinado produto 
	 * @param produto : Produto que será ataualizado
	 * @return <code>true</code> se atualizou com sucesso. <code>false</code> caso contrário.
	 */
	public boolean atualizar(Produto produto);

}
