package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Funcionario;

public interface FuncionarioService {

    /**
     * Salva uma Funcionario no banco.
     * @param  funcionario :  Funcionario a ser salva
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrario.
     */
    public boolean salvar(Funcionario funcionario);

    /**
     * Busca uma Funcionario a partir de seu codigo.
     *
     * @param codigo : codigo da Funcionario
     * @return a Funcionario com o codigo correspondente ou <code>null</code> se nao encontrado.
     */
    public Funcionario buscar(long codigo);
    
    /**
     * Busca uma Funcionario a partir de seu usuario.
     *
     * @param usuario : nome do funcionario no Login
     * @return Funcionario com o usuario correspondente ou <code>null</code> se nao encontrado.
     */
    public Funcionario buscar(String usuario);

}
