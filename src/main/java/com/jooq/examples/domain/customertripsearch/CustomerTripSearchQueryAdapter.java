package com.jooq.examples.domain.customertripsearch;

import com.jooq.examples.domain.customertripsearch.port.CustomerTripSearchQueryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class CustomerTripSearchQueryAdapter implements CustomerTripSearchQueryPort {
    private final CustomerTripSearchRepository customerTripSearchRepository;
    @Override
    public List<CustomerTripSearch> findAll() {
        return customerTripSearchRepository.findAll();
    }
}
