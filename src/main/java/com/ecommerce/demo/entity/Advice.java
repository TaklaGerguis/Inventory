package com.ecommerce.demo.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ADVICE")
public class Advice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(targetEntity = AdviceLine.class, mappedBy = "advice", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<AdviceLine> adviceLines = new ArrayList<>();

    public enum Status {
        PENDING, COMPLETED
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", length = 10)
    private com.ecommerce.demo.entity.Advice.Status status;

    public Advice() {

    }

    public Advice(String name) {
        this.name = name;
        this.status = com.ecommerce.demo.entity.Advice.Status.PENDING;
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

    public Status getStatus() { return status; }

    public void setStatus(Status status) { this.status = status; }

    public List<AdviceLine> getAdviceLines() {
        return adviceLines;
    }

    public void setAdviceLines(List<AdviceLine> adviceLines) {
        this.adviceLines = adviceLines;
    }

    @Override
    public String toString() {
        return "Advice [id=" + id + ", name=" + name + ", adviceLines=" + adviceLines + "]";
    }

}
