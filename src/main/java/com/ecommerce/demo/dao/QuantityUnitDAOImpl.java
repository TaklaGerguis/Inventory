package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.QuantityUnit;
import com.ecommerce.demo.entity.Sku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class QuantityUnitDAOImpl implements QuantityUnitDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public QuantityUnitDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<QuantityUnit> findAll() {

        Session session = sessionFactory.getCurrentSession();

        Query<QuantityUnit> query = session.createQuery("from QuantityUnit ", QuantityUnit.class);

        return query.getResultList();
    }


    @Override
    public QuantityUnit findById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(QuantityUnit.class, id);
    }


    @Override
    public List<QuantityUnit> findByName(String name) {

        Session session = sessionFactory.getCurrentSession();

        Query<QuantityUnit> query = session.createQuery("from QuantityUnit where lower(name) like :name ",
                QuantityUnit.class);

        query.setParameter("name", "%" + name.toLowerCase() + "%");

        return query.getResultList();
    }

    @Override
    public List<QuantityUnit> findBySku(Sku sku) {

        Long skuId = sku.getId();
        System.out.println(sku);

        Session session = sessionFactory.getCurrentSession();

//        Query<QuantityUnit> query1 = session.createQuery
//                ("from QuantityUnit inner join Sku on Sku.id =: skuId ", QuantityUnit.class);
        Query<QuantityUnit> query = session.createQuery
                ("from QuantityUnit inner join Sku on Sku.id = :skuId ", QuantityUnit.class);
//        Query<QuantityUnit> query = session.createQuery
//                ("from QuantityUnit where QuantityUnit.sku =: sku ", QuantityUnit.class);
//        System.out.println(skuId + "fd");
        query.setParameter("skuId", skuId );

//        System.out.println(skuId + "sgradfg");


        return query.getResultList();
    }

    @Override
    public QuantityUnit save(QuantityUnit quantityUnit) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(quantityUnit);
        return null;
    }

    @Override
    public void saveAll(List<QuantityUnit> quantityUnit) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(quantityUnit);
    }

    @Override
    public void deleteById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from QuantityUnit where id =: id");

        query.setParameter("id", id);

        query.executeUpdate();

    }


    @Override
    public void deleteAll(List<QuantityUnit> quantityUnits) {

        Session session = sessionFactory.getCurrentSession();

        for (QuantityUnit qu : quantityUnits) {

            Long id = qu.getId();

            Query query = session.createQuery("delete from QuantityUnit where id =: id");

            query.setParameter("id", id);

            query.executeUpdate();
        }

    }
}