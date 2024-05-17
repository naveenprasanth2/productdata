package com.bharath.springdata.productdata.product.repository;

import com.bharath.springdata.productdata.product.entities.Customer;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmailAndName(@Email String email, String name);

    List<Customer> findByEmailLike(String email);

    List<Customer> findByIdIn(List<Integer> id);
}
