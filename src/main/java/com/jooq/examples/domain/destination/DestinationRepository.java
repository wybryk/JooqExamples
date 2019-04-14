package com.jooq.examples.domain.destination;

import com.jooq.examples.testdb.public_.tables.records.DestinationRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep2;
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

    void insertAll(List<Destination> destinations) {
        InsertValuesStep2<DestinationRecord, Integer, String> step =
                dslContext.insertInto(DESTINATION, DESTINATION.ID, DESTINATION.COUNTRY);
        destinations.forEach(destination -> step.values(destination.getId(), destination.getCountry()));
        step.execute();
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
