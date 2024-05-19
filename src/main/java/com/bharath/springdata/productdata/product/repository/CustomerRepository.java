package com.bharath.springdata.productdata.product.repository;

import com.bharath.springdata.productdata.product.entities.Customer;
import jakarta.validation.constraints.Email;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Optional<Customer> findByEmailAndName(@Email String email, String name);

    List<Customer> findByEmailLike(String email);

    List<Customer> findByIdIn(List<Integer> id);

    List<Customer> findByIdGreaterThanEqual(int id,PageRequest pageRequest);

    @Modifying
    @Query("update Customer set email = :updatedEmail where id = :id  and email = :email")
    void updateCustomerByEmailAndId(@Param("id") int id, @Param("email") String email, @Param("updatedEmail") String updatedEmail);
}
