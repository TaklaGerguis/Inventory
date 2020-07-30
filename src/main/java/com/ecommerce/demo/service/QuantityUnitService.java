package com.ecommerce.demo.service;

import com.ecommerce.demo.entity.QuantityUnit;
import com.ecommerce.demo.entity.Sku;

import java.util.List;

public interface QuantityUnitService {

    List<QuantityUnit> findAll();

    QuantityUnit findById(Long id);

    List<QuantityUnit> findByName(String name);

    List<QuantityUnit> findBySku(Sku sku);

    void save(QuantityUnit quantityUnit);

    void saveAll(List<QuantityUnit> quantityUnit);

    void deleteById(Long id);

    void deleteAll(List<QuantityUnit> quantityUnits);
}
