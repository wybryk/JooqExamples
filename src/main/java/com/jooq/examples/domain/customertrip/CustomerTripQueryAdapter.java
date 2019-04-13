package com.jooq.examples.domain.customertrip;

import com.jooq.examples.domain.customertrip.port.CustomerTripQueryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class CustomerTripQueryAdapter implements CustomerTripQueryPort {
    private final CustomerTripRepository customerTripRepository;

    @Override
    public List<CustomerTrip> findAll() {
        return customerTripRepository.findAll();
    }
}
