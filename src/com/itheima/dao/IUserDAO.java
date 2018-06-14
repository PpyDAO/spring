package com.itheima.dao;

import com.itheima.domain.User;
import org.hibernate.criterion.DetachedCriteria;

import java.sql.SQLException;

public interface IUserDAO {
    User findUserByUsernameAndPassword(DetachedCriteria detachedCriteria) throws SQLException;
}
