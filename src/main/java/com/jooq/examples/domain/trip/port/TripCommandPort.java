package com.jooq.examples.domain.trip.port;

import com.jooq.examples.domain.trip.Trip;

import java.util.List;

public interface TripCommandPort {
    void insert(Trip trip);
    void insertAll(List<Trip> trips);
    void deleteAll();
}
