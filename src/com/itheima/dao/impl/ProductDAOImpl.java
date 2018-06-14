package com.itheima.dao.impl;

import com.itheima.dao.IProductDAO;
import com.itheima.domain.Product;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.SQLException;
import java.util.List;

public class ProductDAOImpl implements IProductDAO {
    @Override
    public List<Product> getAllProduct() throws SQLException {
        Session session = HibernateUtils.getSession();
        Query query = session.createQuery("from Product");
        List<Product> list = query.list();
        session.close();
        return list;
    }

    @Override
    public void addProudct(Product product) throws SQLException {
        Session session = HibernateUtils.getSession();
        session.beginTransaction();
        session.save(product);
        session.getTransaction().commit();
        session.close();
    }
}
