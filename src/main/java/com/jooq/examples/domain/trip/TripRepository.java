package com.jooq.examples.domain.trip;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jooq.examples.testdb.public_.tables.Trip.TRIP;

@Repository
@AllArgsConstructor
class TripRepository {
    private final DSLContext dslContext;

    void insert(Trip trip) {
        dslContext.newRecord(TRIP, trip)
                .insert();
    }

    void deleteAll() {
        dslContext.deleteFrom(TRIP)
                .execute();
    }

    List<Trip> findAll() {
        return dslContext.selectFrom(TRIP)
                .fetchInto(Trip.class);
    }
}
