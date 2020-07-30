package com.ecommerce.demo.service;

import com.ecommerce.demo.entity.Sku;

import java.util.List;

public interface SkuService {

    public List<Sku> getSkues();

    public void save(Sku sku);

    public Sku getSkuBuId(Long id);

    public void deleteById(Long id);

    public List<Sku> searchSkues(String searchName);
}
