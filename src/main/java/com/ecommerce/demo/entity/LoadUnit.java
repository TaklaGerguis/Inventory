package com.ecommerce.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "LOAD_UNIT")
public class LoadUnit  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "LOAD_UNIT_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private com.ecommerce.demo.entity.LoadUnitType loadUnitType;

    @Column(name = "X")
    private int x;

    @Column(name = "Y")
    private int y;

    @Column(name = "Z")
    private int z;

    public LoadUnit() {

    }

    public LoadUnit(com.ecommerce.demo.entity.LoadUnitType loadUnitType, int x, int y, int z) {
        this(x,y,z);
        this.loadUnitType = loadUnitType;
    }

    public LoadUnit(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public com.ecommerce.demo.entity.LoadUnitType getLoadUnitType() {
        return loadUnitType;
    }

    public void setLoadUnitType(com.ecommerce.demo.entity.LoadUnitType loadUnitType) {
        this.loadUnitType = loadUnitType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "LoadUnit{" +
                "id=" + id +
                ", loadUnitType=" + loadUnitType +
                ", x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
