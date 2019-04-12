package com.jooq.examples.domain.customer.port;

import com.jooq.examples.domain.customer.Customer;

import java.util.List;

public interface CustomerCommandPort {
    void insert(Customer customer);
    void insertAll(List<Customer> customers);
    void deleteAll();
    void deleteById(Integer id);
    void update(Customer customer);
}
