package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Produto;

/**
 * Service para manipulação da classe Produto
 */
public interface ProdutoService {

    /**
     * Salva uma Produto no banco.
     * @param  produto :  Produto a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrário.
     */
    public boolean salvar(Produto produto);

    /**
     * Busca uma Produto a partir de seu código.
     *
     * @param codigo : código da Produto
     * @return a Produto com o código correspondente ou <code>null</code> se não encontrado.
     */
    public Produto buscar(long codigo);

}
