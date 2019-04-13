package com.jooq.examples.domain.destination;

import com.jooq.examples.domain.destination.port.DestinationQueryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class DestinationQueryAdapter implements DestinationQueryPort {
    private final DestinationRepository destinationRepository;

    @Override
    public List<Destination> findAll() {
        return destinationRepository.findAll();
    }
}
