package br.unesp.rc.pinguim.models;


/**
 * Define um Pagamento
 */
public class Pagamento {

    private long codigo;
    private String metodoPagamento;
    private Venda venda;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Pagamento
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Pagamento
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de metodoPagamento
     * @param metodoPagamento : metodoPagamento da Pagamento
     */
    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    /**
     * Retorna o valor de metodoPagamento da Pagamento
     * @return Retorna o valor de metodoPagamento
     */
    public String getMetodoPagamento() {
        return this.metodoPagamento;
    } 
    
    /**
     * Define o valor de venda
     * @param venda : venda da Pagamento
     */
    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    /**
     * Retorna o valor de venda da Pagamento
     * @return Retorna o valor de venda
     */
    public Venda getVenda() {
        return this.venda;
    } 
    
}

