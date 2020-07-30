package com.ecommerce.demo.dao;

import com.ecommerce.demo.entity.Sku;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkuDAOImpl implements SkuDAO {


    private SessionFactory sessionFactory;

    @Autowired
    public SkuDAOImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }


    @Override
    public List<Sku> getSkues() {

        Session session = sessionFactory.getCurrentSession();

        Query<Sku> query = session.createQuery("from Sku", Sku.class);

        return query.getResultList();
    }

    @Override
    public void save(Sku sku) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(sku);
    }

    @Override
    public Sku getById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        return session.get(Sku.class, id);
    }


    @Override
    public void deleteById(Long id) {

        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("delete from Sku where id =: skuId");

        query.setParameter("skuId", id);

        query.executeUpdate();
    }

    @Override
    public List<Sku> searchSku(String searchName) {

        Session session = sessionFactory.getCurrentSession();

        Query query = null;

        if (searchName != null && searchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            query =session.createQuery("from Sku where lower(name) like :name "
//                    "or lower(lastName) like :theName"
                    , Sku.class);
            query.setParameter("name", "%" + searchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            query =session.createQuery("from Sku", Sku.class);
        }

        // execute query and get result list
        List<Sku> skues = query.getResultList();

        // return the results
        return skues;
    }
}
