package com.bharath.springdata.productdata;

import com.bharath.springdata.productdata.product.entities.Customer;
import com.bharath.springdata.productdata.product.entities.Product;
import com.bharath.springdata.productdata.product.repository.CustomerRepository;
import com.bharath.springdata.productdata.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ProductdataApplicationTests {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    void contextLoads() {
    }

    @Test
    void testCreate(){
        Product product = new Product();
        product.setId(1);
        product.setName("Iphone");
        product.setDesc("Awesome");
        product.setPrice(1000d);
        productRepository.save(product);
    }

    @Test
    void testRead(){
       Product product = productRepository.findById(1).orElseThrow();
        System.out.println(product);
        assertNotNull(product);
    }

    @Test
    void testUpdate(){
        Product product = productRepository.findById(1).orElseThrow();
        product.setPrice(1200d);
        productRepository.save(product);
    }

    @Test
    void testDelete(){
        productRepository.deleteById(1);
    }

    @Test
    void checkIdExists(){
        assertTrue(productRepository.existsById(1));
    }

    @Test
    void testCount(){
        System.out.println(productRepository.count());
    }

    @Test
    void testCreateCustomer(){
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("naveen");
        customer.setEmail("summa@gmail.com");
        customerRepository.save(customer);
    }

}
