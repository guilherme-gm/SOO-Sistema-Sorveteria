package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.models.Funcionario;

/**
 * Service para manipulacao da classe Funcionario
 */
public interface LoginService {

    
    /**
     * Busca um Funcionario a partir de seu usuario.
     *
     * @param usuario : nome do funcionario no Login
     * @param senha : senha do funcionario no Login
     * @return Funcionario com o usuario correspondente ou <code>null</code> se nao encontrado.
     */
    public Funcionario buscar(String usuario, String senha);

}
