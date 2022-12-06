package br.com.tads.model.enums;

import java.math.BigDecimal;

public enum RoupaEnum {
    CALCA(new BigDecimal("1.0")), 
    BERMUDA(new BigDecimal("1.0")), 
    CAMISA(new BigDecimal("0.5")), 
    CAMISETA(new BigDecimal("2.5"));
    
    private BigDecimal preco;
    
    RoupaEnum(BigDecimal preco){
        this.preco = preco;
    }
    
    public BigDecimal getPreco(){
        return preco;
    }
}
