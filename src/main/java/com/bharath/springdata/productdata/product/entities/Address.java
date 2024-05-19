package com.bharath.springdata.productdata.product.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Embeddable
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
    private String country;
}
