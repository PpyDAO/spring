package com.itheima.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private static SessionFactory sessionFactory = null;
    static {
        Configuration configure = new Configuration().configure();
        sessionFactory = configure.buildSessionFactory();
    }

    public static Session getSession(){
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {

    }
}
