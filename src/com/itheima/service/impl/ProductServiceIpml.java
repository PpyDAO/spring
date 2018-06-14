package com.itheima.service.impl;

import com.itheima.dao.IProductDAO;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceIpml implements IProductService {
    private IProductDAO productDAO;

    public void setProductDAO(IProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAllProduct() throws SQLException {
        return productDAO.getAllProduct();
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        productDAO.addProudct(product);
    }
}
