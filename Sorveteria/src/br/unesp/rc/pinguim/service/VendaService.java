package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Venda;

/**
 * Service para manipulação da classe Venda
 */
public interface VendaService {

    /**
     * Salva uma Venda no banco.
     * @param  venda :  Venda a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrário.
     */
    public boolean salvar(Venda venda);

    /**
     * Busca uma Venda a partir de seu código.
     *
     * @param codigo : código da Venda
     * @return a Venda com o código correspondente ou <code>null</code> se não encontrado.
     */
    public Venda buscar(long codigo);

}
