package br.unesp.rc.pinguim.models;


import java.util.Date;


/**
 * Define um Venda
 */
public class Venda {

    private long codigo;
    private Double total;
    private Date dataVenda;
    private Funcionario vendedor;

    /**
     * Define o valor de codigo
     * @param codigo : codigo da Venda
     */
    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    /**
     * Retorna o valor de codigo da Venda
     * @return Retorna o valor de codigo
     */
    public long getCodigo() {
        return this.codigo;
    } 
    
    /**
     * Define o valor de total
     * @param total : total da Venda
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Retorna o valor de total da Venda
     * @return Retorna o valor de total
     */
    public Double getTotal() {
        return this.total;
    } 
    
    /**
     * Define o valor de dataVenda
     * @param dataVenda : dataVenda da Venda
     */
    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * Retorna o valor de dataVenda da Venda
     * @return Retorna o valor de dataVenda
     */
    public Date getDataVenda() {
        return this.dataVenda;
    } 
    
    /**
     * Define o valor de vendedor
     * @param vendedor : vendedor da Venda
     */
    public void setVendedor(Funcionario vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * Retorna o valor de vendedor da Venda
     * @return Retorna o valor de vendedor
     */
    public Funcionario getVendedor() {
        return this.vendedor;
    } 
    
}

