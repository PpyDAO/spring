package com.itheima.domain;

import javax.persistence.*;

@Entity
@Table(name = "t_product")
public class Product {

    @Id
    @SequenceGenerator(name = "seq", sequenceName = "seq_product",allocationSize = 1)
    @GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private Integer count;
    private Double price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
