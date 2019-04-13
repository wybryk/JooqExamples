package com.jooq.examples.domain.trip;

import com.jooq.examples.domain.trip.port.TripQueryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
class TripQueryAdapter implements TripQueryPort {
    private final TripRepository tripRepository;

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }
}
