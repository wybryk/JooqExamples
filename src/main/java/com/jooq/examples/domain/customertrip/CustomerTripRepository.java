package com.jooq.examples.domain.customertrip;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

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

    void deleteAll() {
        dslContext.deleteFrom(CUSTOMER_TRIP)
                .execute();
    }

    List<CustomerTrip> findAll() {
        return dslContext.selectFrom(CUSTOMER_TRIP)
                .fetchInto(CustomerTrip.class);
    }
}
