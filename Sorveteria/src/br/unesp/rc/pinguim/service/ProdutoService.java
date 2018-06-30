package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Produto;

/**
 * Service para manipula��o da classe Produto
 */
public interface ProdutoService {

    /**
     * Salva uma Produto no banco.
     * @param  produto :  Produto a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contr�rio.
     */
    public boolean salvar(Produto produto);

    /**
     * Busca uma Produto a partir de seu c�digo.
     *
     * @param codigo : c�digo da Produto
     * @return a Produto com o c�digo correspondente ou <code>null</code> se n�o encontrado.
     */
    public Produto buscar(long codigo);

}
