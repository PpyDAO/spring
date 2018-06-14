package com.itheima.dao.impl;

import com.itheima.dao.IUserDAO;
import com.itheima.domain.User;
import com.itheima.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;

import java.sql.SQLException;

public class UserDAOImpl implements IUserDAO {
    @Override
    public User findUserByUsernameAndPassword(DetachedCriteria detachedCriteria) throws SQLException {
        Session session = HibernateUtils.getSession();
        User user = (User) detachedCriteria.getExecutableCriteria(session).uniqueResult();
        session.close();
        return user;
    }
}
