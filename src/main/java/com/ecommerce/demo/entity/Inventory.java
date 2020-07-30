package com.ecommerce.demo.entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "INVENTORY")
public class Inventory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@OneToOne(targetEntity = Sku.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "SKU_ID", referencedColumnName = "ID", nullable = false)
	private Sku sku;

	@OneToOne(targetEntity = QuantityUnit.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "UNIT_ID", referencedColumnName = "ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private QuantityUnit quantityUnit;

	@Column(name = "CURRENT_QUANTITY")
	private int currentQuantity;

	@Column(name = "BEST_BY")
	private Date bestBy;

	public Inventory() {

	}

	public Inventory(Sku sku, QuantityUnit quantityUnit, int currentQuantity, Date bestBy) {
		this.sku = sku;
		this.quantityUnit = quantityUnit;
		this.currentQuantity = currentQuantity;
		this.bestBy = bestBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getCurrentQuantity() {
		return currentQuantity;
	}

	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

	public Date getBestBy() {
		return bestBy;
	}

	public void setBestBy(Date bestBy) {
		this.bestBy = bestBy;
	}

	public Long getSkuId(){
		return sku.getId();
	}

	public Long getUnitId(){
		return quantityUnit.getId();
	}

	public String getSkuName(){
		return sku.getName();
	}

	public String getUnitName(){
		return quantityUnit.getName();
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", sku=" + sku + ", quantityUnit=" + quantityUnit + ", currentQuantity="
				+ currentQuantity + ", bestBy=" + bestBy + "]";
	}

}
