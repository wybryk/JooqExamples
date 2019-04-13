package com.jooq.examples.domain.destination;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jooq.examples.testdb.public_.tables.Destination.DESTINATION;

@Repository
@AllArgsConstructor
class DestinationRepository {
    private final DSLContext dslContext;

    void insert(Destination destination) {
        dslContext.newRecord(DESTINATION, destination)
                .insert();
    }

    void deleteAll() {
        dslContext.deleteFrom(DESTINATION)
                .execute();
    }

    List<Destination> findAll() {
        return dslContext.selectFrom(DESTINATION)
                .fetchInto(Destination.class);
    }
}
