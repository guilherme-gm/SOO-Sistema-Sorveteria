package br.unesp.rc.pinguim.service;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Service para manipulacao da classe Funcionario
 */
public interface FuncionarioService {

    /**
     * Salva um Funcionario no banco.
     * @param  funcionario :  Funcionario a ser salvo
     * @return <code>true</code> se salvou com sucesso. <code>false</code> caso contrario.
     */
    public boolean salvar(Funcionario funcionario);

    /**
     * Busca um Funcionario a partir de seu codigo.
     *
     * @param codigo : codigo da Funcionario
     * @return Funcionario com o codigo correspondente ou <code>null</code> se nao encontrado.
     */
    public Funcionario buscar(long codigo);
    
    /**
     * Busca um Funcionario a partir de seu usuario.
     *
     * @param usuario : nome do funcionario no Login
     * @return Funcionario com o usuario correspondente ou <code>null</code> se nao encontrado.
     */
    public Funcionario buscar(String usuario);

}
