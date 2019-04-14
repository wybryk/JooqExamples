package com.jooq.examples.domain.customertrip;

import com.jooq.examples.testdb.public_.tables.records.CustomerTripRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep5;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import static com.jooq.examples.testdb.public_.tables.CustomerTrip.CUSTOMER_TRIP;

@Repository
@AllArgsConstructor
class CustomerTripRepository {
    private final DSLContext dslContext;

    void insert(CustomerTrip customerTrip) {
        dslContext.newRecord(CUSTOMER_TRIP, customerTrip)
                .insert();
    }

    void insertAll(List<CustomerTrip> customerTrips) {
        InsertValuesStep5<CustomerTripRecord, Integer, Integer, Integer, Date, Timestamp> step =
                dslContext.insertInto(CUSTOMER_TRIP, CUSTOMER_TRIP.ID, CUSTOMER_TRIP.CUSTOMER_ID, CUSTOMER_TRIP.TRIP_ID,
                        CUSTOMER_TRIP.START_DATE, CUSTOMER_TRIP.INSERTION_TIME);
        customerTrips.forEach(customerTrip -> step.values(customerTrip.getId(), customerTrip.getCustomerId(),
                customerTrip.getTripId(), Date.valueOf(customerTrip.getStartDate()), Timestamp.valueOf(customerTrip.getInsertionTime())));
        step.execute();

    }

    void deleteAll() {
        dslContext.deleteFrom(CUSTOMER_TRIP)
                .execute();
    }

    List<CustomerTrip> findAll() {
        return dslContext.selectFrom(CUSTOMER_TRIP)
                .fetchInto(CustomerTrip.class);
    }
}
