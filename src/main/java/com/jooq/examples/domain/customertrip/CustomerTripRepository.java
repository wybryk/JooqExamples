package com.jooq.examples.domain.customertrip;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
class CustomerTripRepository {
    private final DSLContext dslContext;
}
