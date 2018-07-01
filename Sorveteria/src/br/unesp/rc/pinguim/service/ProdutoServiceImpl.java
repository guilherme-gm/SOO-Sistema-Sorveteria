package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.ProdutoDAO;
import br.unesp.rc.pinguim.models.Produto;

/**
 * Service com ações relacionadas a um Produto
 */
public class ProdutoServiceImpl implements ProdutoService {

    private ProdutoDAO produtoDAO;

    /**
     * Inicializa o Service e cria uma instância da DAO usada.
     */
    public ProdutoServiceImpl() {
        this.produtoDAO = DAOFactory.getProdutoDAO();
    }

    /**
     * Salva um produto
     * @param produto : produto a ser salvo
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrário.
     */
    @Override
    public boolean salvar(Produto produto) {
        boolean b = false;
        
        b = this.produtoDAO.salvar(produto);
        
        return b;
    }

    /**
     * Busca um Produto a partir de seu código.
     *
     * @param codigo : código do Produto
     * @return o Produto com o código correspondente ou <code>null</code> se não encontrado.
     */
    @Override
    public Produto buscar(long codigo) {
        return this.produtoDAO.buscarPorCodigo(codigo);
    }

    
    /**
     * Busca um Produto a partir do seu nome
     * @param nome :  nome do Produto
     * @return Produto com o nome correspondente ou <code>null</code> se não encontrado.
     */
	@Override
	public Produto buscar(String nome) {
		return this.produtoDAO.BuscarPorNome(nome);
	}

	/**
     * Busca todos os produtos
     * @return Uma lista de produtos
     */
	@Override
	public List<Produto> buscarTodos() {
		
		return this.produtoDAO.BuscarTodos();
	}

	/**
	 * Atualiza um determinado produto 
	 * @param produto : Produto que será ataualizado
	 * @return <code>true</code> se atualizou com sucesso. <code>false</code> caso contrário.
	 */
	@Override
	public boolean atualizar(Produto produto) {
		
		return this.produtoDAO.AtualizarProduto(produto);
	}
    
    

}
