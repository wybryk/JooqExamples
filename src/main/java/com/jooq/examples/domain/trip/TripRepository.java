package com.jooq.examples.domain.trip;

import com.jooq.examples.testdb.public_.tables.records.TripRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep6;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    void insertAll(List<Trip> trips) {
        InsertValuesStep6<TripRecord, Integer, String, String, Integer, BigDecimal, Integer> step =
                dslContext.insertInto(TRIP, TRIP.ID, TRIP.TITLE, TRIP.TRANSPORT_TYPE, TRIP.DURATION, TRIP.PRICE, TRIP.DESTINATION_ID);
        trips.forEach(trip -> step.values(trip.getId(), trip.getTitle(), trip.getTransportType().toString(), trip.getDuration(), trip.getPrice(), trip.getDestinationId()));
        step.execute();
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
