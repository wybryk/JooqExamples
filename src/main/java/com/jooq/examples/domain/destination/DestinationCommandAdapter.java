package com.jooq.examples.domain.destination;

import com.jooq.examples.domain.destination.port.DestinationCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class DestinationCommandAdapter implements DestinationCommandPort {
    private final DestinationRepository destinationRepository;

    @Override
    public void insert(Destination destination) {
        destinationRepository.insert(destination);
    }

    @Override
    public void deleteAll() {
        destinationRepository.deleteAll();
    }
}
