package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.Sku;

import java.util.List;


public interface SkuDAO {

    List<Sku> getSkues();

    void save(Sku sku);

    Sku getById(Long id);

    void deleteById(Long id);

    List<Sku> searchSku(String searchName);
}
