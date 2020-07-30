package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.SkuDAO;
import com.ecommerce.demo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkuServiceImpl implements SkuService{

    private SkuDAO skuDAO;

    @Autowired
    public SkuServiceImpl(SkuDAO skuDAO){
        this.skuDAO=skuDAO;
    }

    @Override
    @Transactional
    public List<Sku> getSkues() {
        return skuDAO.getSkues();
    }

    @Override
    @Transactional
    public void save(Sku sku) {
        skuDAO.save(sku);
    }

    @Override
    @Transactional
    public Sku getSkuBuId(Long id) {
        return skuDAO.getById(id);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        skuDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<Sku> searchSkues(String searchName) {
        return skuDAO.searchSku(searchName);
    }
}
