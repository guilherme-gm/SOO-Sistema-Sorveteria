package br.unesp.rc.pinguim.service;

import java.util.List;

import br.unesp.rc.pinguim.models.Notificacao;

/**
 * Service para manipula��o da classe Notifica��o
 */
public interface NotificacaoService {

	/**
	 * Salva uma Notifica��o
	 * 
	 * @param notificacao
	 *            : Notifica��o a ser salva
	 * @return <code>true</code> se salvou com sucesso. <code>false</code> caso
	 *         contr�rio.
	 */
	public boolean salvar(Notificacao notificacao);

	/**
	 * Marca uma notifica��o como lida
	 * 
	 * @param id
	 *            ID da notifica��o
	 * @return <code>true</code> em caso de sucesso, <code>false</code> caso
	 *         contr�rio
	 */
	public boolean ler(long id);

	/**
	 * Retorna as ultimas <code>quantidade</code> notifica��es. Levando em conta
	 * todas ou apenas as n�o lidas
	 * 
	 * @param quantidade numero de notifica��es para retornar
	 * @param apenasNovas se deve retornar apenas as n�o lidas (<code>true</code>)
	 * @return lista de notifica��es
	 */
	public List<Notificacao> listar(int quantidade, boolean apenasNovas);

}
