package com.jooq.examples.domain.customertrip;

import com.jooq.examples.domain.customertrip.port.CustomerTripCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class CustomerTripCommandAdapter implements CustomerTripCommandPort {
    private final CustomerTripRepository customerTripRepository;

    @Override
    public void insert(CustomerTrip customerTrip) {
        customerTripRepository.insert(customerTrip);
    }

    @Override
    public void deleteAll() {
        customerTripRepository.deleteAll();
    }
}
