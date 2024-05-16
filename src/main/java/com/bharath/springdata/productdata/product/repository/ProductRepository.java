package com.bharath.springdata.productdata.product.repository;

import com.bharath.springdata.productdata.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
