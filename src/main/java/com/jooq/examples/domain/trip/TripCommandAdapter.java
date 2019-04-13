package com.jooq.examples.domain.trip;

import com.jooq.examples.domain.trip.port.TripCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
class TripCommandAdapter implements TripCommandPort {
    private final TripRepository tripRepository;

    @Override
    public void insert(Trip trip) {
        tripRepository.insert(trip);
    }

    @Override
    public void deleteAll() {
        tripRepository.deleteAll();
    }
}
