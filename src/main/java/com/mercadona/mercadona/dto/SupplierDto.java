package com.mercadona.mercadona.dto;

/**
 * Class to show information about supplier
 */
public class SupplierDto {

    private Long referenceCode;

    private String nameSupplier;

    private String direction;

    public SupplierDto() {
    }

    public Long getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(Long referenceCode) {
        this.referenceCode = referenceCode;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
