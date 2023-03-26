package com.mercadona.mercadona.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Class supplier that represents database fields
 */
@Entity
@Table(name = "SUPPLIER")
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "referenceCode", unique = true)
    private Long referenceCode;

    @Column(name = "nameSupplier")
    private String nameSupplier;

    @Column(name = "direction")
    private String direction;

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY)
    private List<Product> products;

    public Supplier() {
    }

    public Long getReferenceCode() {
        return referenceCode;
    }

    public void setReferenceCode(Long referenceCode) {
        this.referenceCode = referenceCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
