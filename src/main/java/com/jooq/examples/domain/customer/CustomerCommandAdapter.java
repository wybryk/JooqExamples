package com.jooq.examples.domain.customer;

import com.jooq.examples.domain.customer.port.CustomerCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class CustomerCommandAdapter implements CustomerCommandPort {
    private final CustomerRepository customerRepository;

    @Override
    public void insert(Customer customer) {
        customerRepository.insert(customer);
    }

    @Override
    public void insertAll(List<Customer> customers) {
        customerRepository.insertAll(customers);
    }

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        customerRepository.deleteById(id);
    }
}
