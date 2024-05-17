package com.bharath.springdata.productdata.product.repository;

import com.bharath.springdata.productdata.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndDesc(String name, String desc);
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByDescContains(String desc);
    List<Product> findByPriceBetween(double from, double to);
    List<Product> findByDescLike(String desc);
    List<Product> findByIdIn(List<Integer> ids);
}
