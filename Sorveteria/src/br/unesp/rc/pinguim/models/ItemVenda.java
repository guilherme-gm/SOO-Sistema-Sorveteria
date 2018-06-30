package br.unesp.rc.pinguim.models;


/**
 * Define um ItemVenda
 */
public class ItemVenda {

    private int quantidade;
    private Double valorUnidade;

    /**
     * Define o valor de quantidade
     * @param quantidade : quantidade da ItemVenda
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna o valor de quantidade da ItemVenda
     * @return Retorna o valor de quantidade
     */
    public int getQuantidade() {
        return this.quantidade;
    } 
    
    /**
     * Define o valor de valorUnidade
     * @param valorUnidade : valorUnidade da ItemVenda
     */
    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    /**
     * Retorna o valor de valorUnidade da ItemVenda
     * @return Retorna o valor de valorUnidade
     */
    public Double getValorUnidade() {
        return this.valorUnidade;
    } 
    
}

