package com.ecommerce.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "ADVICE_LINE")
public class AdviceLine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ADVICE_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private com.ecommerce.demo.entity.Advice advice;

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
		PENDING, COMPLETED
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", length = 10)
	private Status status;

	public AdviceLine() {

	}

	public AdviceLine(com.ecommerce.demo.entity.Advice advice, Sku sku, QuantityUnit quantityUnit, int quantity, Date expDate) {
		this.advice = advice;
		this.sku = sku;
		this.quantityUnit = quantityUnit;
		this.quantity = quantity;
		this.expDate = expDate;
		this.status = Status.PENDING;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public com.ecommerce.demo.entity.Advice getAdvice() {
		return advice;
	}

	public void setAdvice(com.ecommerce.demo.entity.Advice advice) {
		this.advice = advice;
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

	public void setUnit(QuantityUnit quantityUnit) {
		this.quantityUnit = quantityUnit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public long getSkuId() {
		return sku.getId();
	}

	public void setSkuId(Long id) {
		sku.setId(id);
	}

	@Override
	public String toString() {
		return "AdviceLine [id=" + id + ", advice=" + advice + ", sku=" + sku + ", unit=" + quantityUnit + ", quantity="
				+ quantity + ", expDate=" + expDate + ", status=" + status + "]";
	}

}
