package com.ecommerce.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SKU")
public class Sku {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(targetEntity = QuantityUnit.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "sku")
    private List<QuantityUnit> units;

    //    public Sku() {
//
//        this.units = new ArrayList<>();
//    }
    public Sku() {
    }

    public Sku(String name) {
        // this();
        this.name = name;
    }

    public Sku(String name, List<QuantityUnit> units) {
        this(name);
//        this.units = units;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuantityUnit> getUnits() {
        return units;
    }

    public void setUnits(List<QuantityUnit> units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Sku [id=" + id + ", name=" + name + ", units=" + units + "]";
    }

}