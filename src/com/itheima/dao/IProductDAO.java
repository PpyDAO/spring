package com.itheima.dao;

import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    List<Product> getAllProduct() throws SQLException;

    void addProudct(Product product) throws SQLException;
}
