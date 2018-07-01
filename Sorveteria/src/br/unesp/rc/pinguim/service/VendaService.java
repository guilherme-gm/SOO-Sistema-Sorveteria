package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Venda;

/**
 * Service para manipula��o da classe Venda
 */
public interface VendaService {

    /**
     * Salva uma Venda no banco.
     * @param  venda :  Venda a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contr�rio.
     */
    public boolean salvar(Venda venda);

    /**
     * Busca uma Venda a partir de seu c�digo.
     *
     * @param codigo : c�digo da Venda
     * @return a Venda com o c�digo correspondente ou <code>null</code> se n�o encontrado.
     */
    public Venda buscar(long codigo);

}
