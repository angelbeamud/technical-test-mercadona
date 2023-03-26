package com.mercadona.mercadona.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Class destiny that represents database fields
 */
@Entity
@Table(name = "DESTINY")
public class Destiny {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "nameDestiny")
    private String nameDestiny;

    @OneToMany(mappedBy = "destiny", fetch = FetchType.LAZY)
    private List<Product> products;

    public Destiny() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameDestiny() {
        return nameDestiny;
    }

    public void setNameDestiny(String nameDestiny) {
        this.nameDestiny = nameDestiny;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
