package com.jooq.examples.domain.destination;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class DestinationRepository {
    private final DSLContext dslContext;
}
