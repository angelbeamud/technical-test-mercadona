package com.mercadona.mercadona.dto;

/**
 * Class with information about EAN
 */
public class EANDto {

    private Long barCode;

    public EANDto() {
    }

    public Long getBarCode() {
        return barCode;
    }

    public void setBarCode(Long barCode) {
        this.barCode = barCode;
    }

    public Long getSupplierReference() {
        return Long.parseLong(String.valueOf(this.barCode).substring(0, 7));
    }

    public Long getProductReference() {
        return Long.parseLong(String.valueOf(this.barCode).substring(7, 12));
    }
    
    public Long getDestinyNum() {
        return Long.parseLong(String.valueOf(this.barCode).substring(String.valueOf(this.barCode).length() - 1));
    }
}
