package com.bharath.springdata.productdata.product.repository;

import com.bharath.springdata.productdata.product.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
