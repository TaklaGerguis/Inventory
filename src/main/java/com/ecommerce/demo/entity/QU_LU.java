package com.ecommerce.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "QU_LU")
public class QU_LU {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "QUANTITY_UNIT_ID")
    private QuantityUnit quantityUnit;

    @ManyToOne
    @JoinColumn(name = "LOAD_UNIT_TYPE_ID")
    private com.ecommerce.demo.entity.LoadUnitType loadUnitType;

    @Column(name = "MAX_CAPACITY")
    private int maxCapacity;

    @Column(name = "CURRENT_CAPACITY")
    private int currentCapacity;

    @Column(name = "AVAILABLE_CAPACITY")
    private int availableCapacity;

    public QU_LU() {

    }

    public QU_LU(QuantityUnit quantityUnit, com.ecommerce.demo.entity.LoadUnitType loadUnitType) {
        this.quantityUnit = quantityUnit;
        this.loadUnitType = loadUnitType;
        this.maxCapacity = loadUnitType.getCapacityUnit() / quantityUnit.getCapacityUnit();
        this.currentCapacity = 0;
        this.availableCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(QuantityUnit quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public com.ecommerce.demo.entity.LoadUnitType getLoadUnitType() {
        return loadUnitType;
    }

    public void setLoadUnitType(com.ecommerce.demo.entity.LoadUnitType loadUnitType) {
        this.loadUnitType = loadUnitType;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public int getAvailableCapacity() {
        return maxCapacity - currentCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

    @Override
    public String toString() {
        return "QU_LU{" +
                "id=" + id +
                ", quantityUnit=" + quantityUnit +
                ", loadUnitType=" + loadUnitType +
                ", maxCapacity=" + maxCapacity +
                ", currentCapacity=" + currentCapacity +
                ", availableCapacity=" + availableCapacity +
                '}';
    }
}
