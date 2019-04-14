package com.jooq.examples.domain.trip;

import com.jooq.examples.domain.trip.port.TripCommandPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class TripCommandAdapter implements TripCommandPort {
    private final TripRepository tripRepository;

    @Override
    public void insert(Trip trip) {
        tripRepository.insert(trip);
    }

    @Override
    public void insertAll(List<Trip> trips) {
        tripRepository.insertAll(trips);
    }

    @Override
    public void deleteAll() {
        tripRepository.deleteAll();
    }
}
