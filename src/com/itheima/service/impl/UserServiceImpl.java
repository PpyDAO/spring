package com.itheima.service.impl;

import com.itheima.dao.IUserDAO;
import com.itheima.dao.impl.UserDAOImpl;
import com.itheima.domain.User;
import com.itheima.service.IUserService;
import org.hibernate.criterion.DetachedCriteria;

import java.sql.SQLException;

public class UserServiceImpl implements IUserService {
    @Override
    public User login(DetachedCriteria detachedCriteria) throws SQLException {
        IUserDAO userDAO = new UserDAOImpl();
        return userDAO.findUserByUsernameAndPassword(detachedCriteria);
    }
}
