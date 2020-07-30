package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.*;

import java.util.List;

public interface InventoryDAO {

    List<Inventory> findAll();

    Inventory findById(Long id);

    List<Inventory> findBySku(Sku sku);

    Inventory findByQuantityUnit(QuantityUnit quantityUnitId);

    Inventory findBySkuAndQuantityUnit(Sku sku, QuantityUnit quantityUnit);

    Inventory executeAdviceLine(AdviceLine adviceLine);

    Inventory executeOrderLine(OrderLine orderLine);

    void executeInvoice();

    Inventory save(Inventory inventory);

    void deleteById(Long id);
}
