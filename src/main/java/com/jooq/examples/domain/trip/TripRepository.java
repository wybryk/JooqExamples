package com.jooq.examples.domain.trip;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class TripRepository {
    private final DSLContext dslContext;
}
