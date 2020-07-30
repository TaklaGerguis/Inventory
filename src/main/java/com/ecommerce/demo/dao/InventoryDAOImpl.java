package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventoryDAOImpl implements InventoryDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public InventoryDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Inventory> findAll() {

        Session session = sessionFactory.getCurrentSession();

        Query<Inventory> query = session.createQuery("from Inventory ", Inventory.class);

        return query.getResultList();
    }

    @Override
    public Inventory findById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Inventory.class, id);

    }

    @Override
    public List<Inventory> findBySku(Sku sku) {
        return null;
    }

    @Override
    public Inventory findByQuantityUnit(QuantityUnit quantityUnitId) {
        return null;
    }

    @Override
    public Inventory findBySkuAndQuantityUnit(Sku sku, QuantityUnit quantityUnit) {
        return null;
    }

    @Override
    public Inventory executeAdviceLine(AdviceLine adviceLine) {
        return null;
    }

    @Override
    public Inventory executeOrderLine(OrderLine orderLine) {
        return null;
    }

    @Override
    public void executeInvoice() {

    }

    @Override
    public Inventory save(Inventory inventory) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(inventory);

        return inventory;
    }

    @Override
    public void deleteById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Inventory where id =: inventoryId");

        query.setParameter("inventoryId", id);

        query.executeUpdate();
    }
}
