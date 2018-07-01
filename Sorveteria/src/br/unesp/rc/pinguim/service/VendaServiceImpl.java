package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.dao.DAOFactory;
import br.unesp.rc.pinguim.dao.VendaDAO;
import br.unesp.rc.pinguim.models.Venda;

/**
 * Service com a��es relacionadas a uma Venda
 */
public class VendaServiceImpl implements VendaService {

    private VendaDAO vendaDAO;

    /**
     * Inicializa o Service e cria uma inst�ncia da DAO usada.
     */
    public VendaServiceImpl() {
        this.vendaDAO = DAOFactory.getVendaDAO();
    }

    /**
     * Salva uma venda
     * @param venda : venda a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contr�rio.
     */
    @Override
    public boolean salvar(Venda venda) {
        boolean b = false;
        
        b = this.vendaDAO.salvar(venda);
        
        return b;
    }

    /**
     * Busca uma Venda a partir de seu c�digo.
     *
     * @param codigo : c�digo da Venda
     * @return a Venda com o c�digo correspondente ou <code>null</code> se n�o encontrado.
     */
    @Override
    public Venda buscar(long codigo) {
        return this.vendaDAO.buscarPorCodigo(codigo);
    }

}
