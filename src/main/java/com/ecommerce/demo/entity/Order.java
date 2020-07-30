package com.ecommerce.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(targetEntity = OrderLine.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderLine> orderLines = new ArrayList<>();

    public enum Status {
        PENDING, COMPLETED
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 10)
    private com.ecommerce.demo.entity.Order.Status status;

    public Order() {

    }

    public Order(String name) {
        this.name = name;
        this.status = Status.PENDING;
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

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    @Override
    public String toString() {
        return "Order [id=" + id + ", name=" + name + ", orderLines=" + orderLines + "]";
    }

}
