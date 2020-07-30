package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.QuantityUnit;
import com.ecommerce.demo.entity.Sku;

import java.util.List;


public interface QuantityUnitDAO{

    List<QuantityUnit> findAll();

    QuantityUnit findById(Long id);

    List<QuantityUnit> findByName(String name);

    List<QuantityUnit> findBySku(Sku sku);

    QuantityUnit save(QuantityUnit quantityUnit);

    void saveAll(List<QuantityUnit> quantityUnit);

    void deleteById(Long id);

    void deleteAll(List<QuantityUnit> quantityUnits);
}
