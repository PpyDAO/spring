package com.itheima.service;

import com.itheima.domain.User;
import org.hibernate.criterion.DetachedCriteria;

import java.sql.SQLException;

public interface IUserService {
    User login(DetachedCriteria detachedCriteria) throws SQLException;
}
