package com.itheima.action;

import com.itheima.domain.Product;
import com.itheima.service.IProductService;
import com.itheima.service.impl.ProductServiceIpml;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.apache.struts2.convention.annotation.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@Namespace("/")
@ParentPackage("product")
@InterceptorRef("myStack")
public class ProductAction extends ActionSupport implements ModelDriven<com.itheima.domain.Result<Product>> {
    private com.itheima.domain.Result<Product> result = new com.itheima.domain.Result<Product>();
    private Product product;
    private IProductService productService;

    public ProductAction() {
        super();
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        this.productService = (ProductServiceIpml)applicationContext.getBean("productService");
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public com.itheima.domain.Result<Product> getModel() {
        return result;
    }

    @Action(value = "showProduct", results = {@Result(name = "success", type = "json")})
    public String showProdcut(){
        try {
            List<Product> products = productService.getAllProduct();
            result.setType("1");
            result.setContent(products);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Action(value = "addProduct", results = {@Result(name = "success", type = "json")})
    public String addProdcut(){
        try {
            productService.addProduct(product);
            result.setType("1");
            result.setMessage("添加成功!");
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
