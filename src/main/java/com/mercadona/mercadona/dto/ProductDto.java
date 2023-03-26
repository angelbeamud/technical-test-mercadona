package com.mercadona.mercadona.dto;

import java.math.BigDecimal;

/**
 * Class to show information about product
 */
public class ProductDto {

    private Long referenceCode;

    private String nameProduct;

    private BigDecimal price;

    private Boolean isFrozen;

    private SupplierDto supplier;

    private DestinyDto destiny;

    public ProductDto() {
    }

    public Long getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(Long referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Boolean getFrozen() {
        return isFrozen;
    }

    public void setFrozen(Boolean frozen) {
        isFrozen = frozen;
    }

    public SupplierDto getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierDto supplier) {
        this.supplier = supplier;
    }

    public DestinyDto getDestiny() {
        return destiny;
    }

    public void setDestiny(DestinyDto destiny) {
        this.destiny = destiny;
    }
}
