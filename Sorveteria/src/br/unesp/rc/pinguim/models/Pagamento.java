package br.unesp.rc.pinguim.models;


/**
 * Define um Pagamento
 */
public class Pagamento {

    private long codigo;
    private String metodoPagamento;
    

    public Pagamento(String metodoPagamento) {
		super();
		this.metodoPagamento = metodoPagamento;
	}

	/**
     * Define o valor de codigo
     * @param codigo : codigo do Pagamento
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo do Pagamento
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de metodoPagamento
     * @param metodoPagamento : metodoPagamento do Pagamento
     */
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Retorna o valor de metodoPagamento do Pagamento
     * @return Retorna o valor de metodoPagamento
     */
    public String getMetodoPagamento() {
        return this.metodoPagamento;
    } 
     
    
}

