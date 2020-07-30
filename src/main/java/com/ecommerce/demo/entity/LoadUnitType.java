package com.ecommerce.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "LOAD_UNIT_TYPE")
public class LoadUnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CAPACITY_UNIT")
    private int capacityUnit;

    @OneToMany(targetEntity = LoadUnit.class, mappedBy = "loadUnitType", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<LoadUnit> loadUnits = new ArrayList<>();

    @OneToMany(mappedBy = "loadUnitType")
    private List<QU_LU> quLuList = new ArrayList<>();

    public LoadUnitType() {

    }

    public LoadUnitType(String name, int capacityUnit) {
        this.name = name;
        this.capacityUnit = capacityUnit;
    }

    public LoadUnitType(String name, int capacityUnit, List<LoadUnit> loadUnits) {
        this(name, capacityUnit);
        this.loadUnits = loadUnits;
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

    public List<LoadUnit> getLoadUnits() {
        return loadUnits;
    }

    public void setLoadUnits(List<LoadUnit> loadUnits) {
        this.loadUnits = loadUnits;
    }

    public List<QU_LU> getQuLuList() {
        return quLuList;
    }

    public void setQuLuList(List<QU_LU> quLuList) {
        this.quLuList = quLuList;
    }

    public int getCapacityUnit() {
        return capacityUnit;
    }

    public void setCapacityUnit(int capacityUnit) {
        this.capacityUnit = capacityUnit;
    }

    @Override
    public String toString() {
        return "LoadUnitType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capacityUnit=" + capacityUnit +
                ", loadUnits=" + loadUnits +
                ", quLuList=" + quLuList +
                '}';
    }
}
