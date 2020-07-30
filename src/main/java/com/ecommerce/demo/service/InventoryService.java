package com.ecommerce.demo.service;

import com.ecommerce.demo.entity.*;

import java.util.List;

public interface InventoryService {

	public List<Inventory> findAll();

	public Inventory findById(Long id);
//
//	public List<Inventory> findBySku(Sku sku);
//
//	public Inventory findByQuantityUnit(QuantityUnit quantityUnitId);
//
//	public Inventory findBySkuAndQuantityUnit(Sku sku, QuantityUnit quantityUnit);
//
//	public Inventory executeAdviceLine(AdviceLine adviceLine);
//
//	public Inventory executeOrderLine(OrderLine orderLine);
//
//	public void executeInvoice();
//
	public Inventory save(Inventory inventory);
//
//	public void deleteById(Long id);
}
