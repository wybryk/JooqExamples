package com.jooq.examples.domain.customer.port;

import com.jooq.examples.domain.customer.Customer;

import java.util.List;

public interface CustomerQueryPort {
    List<Customer> findAll();
    Customer findById(Integer id);
    List<Customer> findByFirstName(String firstName);
}
