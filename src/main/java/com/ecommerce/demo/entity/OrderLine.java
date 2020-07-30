package com.ecommerce.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ORDER_LINE")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(targetEntity = com.ecommerce.demo.entity.Order.class, fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ORDER_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private com.ecommerce.demo.entity.Order order;

	@OneToOne(targetEntity = Sku.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SKU_ID", referencedColumnName = "ID", nullable = false)
	private Sku sku;

	@OneToOne(targetEntity = QuantityUnit.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID", referencedColumnName = "ID", nullable = false)
	private QuantityUnit quantityUnit;

	@Column(name = "QUANTITY")
	private int quantity;

	@Column(name = "EXP_DATE")
	private Date expDate;

	public enum Status {
		PENDING, COPMLETED
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 10)
	private Status status;

	public OrderLine() {

	}

	public OrderLine(com.ecommerce.demo.entity.Order order, Sku sku, QuantityUnit quantityUnit, int quantity, Date expDate) {
		this.order = order;
		this.sku = sku;
		this.quantityUnit = quantityUnit;
		this.quantity = quantity;
		this.status = Status.PENDING;
		this.expDate = expDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public com.ecommerce.demo.entity.Order getOrder() {
		return order;
	}

	public void setOrder(com.ecommerce.demo.entity.Order order) {
		this.order = order;
	}

	public Sku getSku() {
		return sku;
	}

	public void setSku(Sku sku) {
		this.sku = sku;
	}

	public QuantityUnit getQuantityUnit() {
		return quantityUnit;
	}

	public void setQuantityUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", order=" + order + ", sku=" + sku + ", quantityUnit=" + quantityUnit
				+ ", quantity=" + quantity + ", status=" + status + "]";
	}

}
