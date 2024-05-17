package com.bharath.springdata.productdata;

import com.bharath.springdata.productdata.product.entities.Customer;
import com.bharath.springdata.productdata.product.entities.Product;
import com.bharath.springdata.productdata.product.repository.CustomerRepository;
import com.bharath.springdata.productdata.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.util.List;

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

    @Test
    void testFindByName(){
        productRepository.findByName("IWatch").forEach(System.out::println);
    }

    @Test
    void testFindByNameAndDesc(){
        productRepository.findByNameAndDesc("TV", "From Samsumg Inc").forEach(System.out::println);
    }

    @Test
    void testFindByPriceGreaterThanThousand(){
        productRepository.findByPriceGreaterThan(1000D).forEach(System.out::println);
    }


    @Test
    void testFindByDescContains(){
        productRepository.findByDescContains("apple").forEach(System.out::println);
    }

    @Test
    void testFindByPriceBetween(){
        productRepository.findByPriceBetween(500d, 2500d).forEach(System.out::println);
    }

    @Test
    void testFindByDescLike(){
        productRepository.findByDescLike("%Inc").forEach(System.out::println);
    }

    @Test
    void testFindByIdIn(){
        productRepository.findByIdIn(List.of(1, 2)).forEach(System.out::println);
    }


    @Test
    void testFindByEmailAndName(){
       Customer customer = customerRepository.findByEmailAndName("summa@gmail.com", "naveen").orElseThrow();
        System.out.println(customer);
    }

    @Test
    void testFindByEmailLike(){
        customerRepository.findByEmailLike("%@%").forEach(System.out::println);

    }

    @Test
    void testFindCustomerByIdIn(){
        customerRepository.findByIdIn(List.of(1)).forEach(System.out::println);
    }

    @Test
    void testFindAllPaging(){
        PageRequest pageable = PageRequest.of(0, 2);
        productRepository.findAll(pageable).forEach(System.out::println);
    }

    @Test
    void testFindAllSorting(){
        Sort sort = Sort.by("name");
        productRepository.findAll(sort).forEach(System.out::println);
    }

    @Test
    void testFindAllSortingDesc(){
        Sort sort = Sort.by("name").descending();
        productRepository.findAll(sort).forEach(System.out::println);
    }


    @Test
    void testFindAllSortingMultiple(){
        Sort sort = Sort.by("price","name").descending();
        productRepository.findAll(sort).forEach(System.out::println);
    }

    @Test
    void testFindAllSortingMultipleWithMultipleOrders(){
        Sort sort = Sort.by(Sort.Order.asc("name"), Sort.Order.desc("price"));
        productRepository.findAll(sort).forEach(System.out::println);
    }

    @Test
    void testFindAllWithPagingAndSorting(){
        Sort sort = Sort.by(Sort.Order.asc("name"));
        PageRequest pageRequest = PageRequest.of(0, 2).withSort(sort);
        productRepository.findAll(pageRequest).forEach(System.out::println);

    }
}
