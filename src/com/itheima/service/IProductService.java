package com.itheima.service;

import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductService {
    List<Product> getAllProduct() throws SQLException;

    void addProduct(Product product) throws SQLException;
}
