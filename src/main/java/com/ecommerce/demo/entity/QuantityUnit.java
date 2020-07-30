package com.ecommerce.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "QUANTITY_UNIT")
public class QuantityUnit {

    @javax.persistence.Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY_UNIT")
    private int capacityUnit;

    @ManyToOne(targetEntity = Sku.class, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "SKU_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sku sku;
//
//    @OneToMany(mappedBy = "quantityUnit")
//    private List<QU_LU> quLuList;

    public QuantityUnit() {

    }

    public QuantityUnit(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public Sku getSku() {
        return sku;
    }

    public void setSku(Sku sku) {
        this.sku = sku;
    }

//    public List<QU_LU> getQuLuList() {
//        return quLuList;
//    }

    public int getCapacityUnit() {
        return capacityUnit;
    }

    public void setCapacityUnit(int capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

//    public void setQuLuList(List<QU_LU> quLuList) {
//        this.quLuList = quLuList;
//    }

    @Override
    public String toString() {
        return "QuantityUnit{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", capacityUnit=" + capacityUnit +
//                ", quLuList=" + quLuList +
                '}';
    }

}