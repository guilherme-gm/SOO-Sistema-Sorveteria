package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.ProdutoDAO;
import br.unesp.rc.pinguim.models.Produto;

/**
 * Service com a��es relacionadas a uma Produto
 */
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoDAO produtoDAO;

    /**
     * Inicializa o Service e cria uma inst�ncia da DAO usada.
     */
    public ProdutoServiceImpl() {
        this.produtoDAO = DAOFactory.getProdutoDAO();
    }

    /**
     * Salva um produto
     * @param produto : produto a ser salvo
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contr�rio.
     */
    @Override
    public boolean salvar(Produto produto) {
        boolean b = false;
        
        b = this.produtoDAO.salvar(produto);
        
        return b;
    }

    /**
     * Busca um Produto a partir de seu c�digo.
     *
     * @param codigo : c�digo do Produto
     * @return o Produto com o c�digo correspondente ou <code>null</code> se n�o encontrado.
     */
    @Override
    public Produto buscar(long codigo) {
        return this.produtoDAO.buscarPorCodigo(codigo);
    }

}