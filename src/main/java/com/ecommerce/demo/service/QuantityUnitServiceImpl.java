package com.ecommerce.demo.service;

import com.ecommerce.demo.dao.QuantityUnitDAO;
import com.ecommerce.demo.entity.QuantityUnit;
import com.ecommerce.demo.entity.Sku;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuantityUnitServiceImpl implements QuantityUnitService{

    private QuantityUnitDAO quantityUnitDAO;

    @Autowired
    public QuantityUnitServiceImpl(QuantityUnitDAO quantityUnitDAO){

        this.quantityUnitDAO=quantityUnitDAO;
    }

    @Override
    @Transactional
    public List<QuantityUnit> findAll() {
        return quantityUnitDAO.findAll();
    }

    @Override
    @Transactional
    public QuantityUnit findById(Long id) {
        return quantityUnitDAO.findById(id);
    }

    @Override
    @Transactional
    public List<QuantityUnit> findByName(String name) {
        return quantityUnitDAO.findByName(name);
    }

    @Override
    @Transactional
    public List<QuantityUnit> findBySku(Sku sku) {



        return quantityUnitDAO.findBySku(sku);
    }

    @Override
    @Transactional
    public void save(QuantityUnit quantityUnit) {
        quantityUnitDAO.save(quantityUnit);
    }

    @Override
    @Transactional
    public void saveAll(List<QuantityUnit> quantityUnit) {
        quantityUnitDAO.saveAll(quantityUnit);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        quantityUnitDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteAll(List<QuantityUnit> quantityUnits) {
        quantityUnitDAO.deleteAll(quantityUnits);
    }
}
