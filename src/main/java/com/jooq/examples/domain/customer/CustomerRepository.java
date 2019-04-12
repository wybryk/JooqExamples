package com.jooq.examples.domain.customer;

import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jooq.examples.testdb.public_.tables.Customer.CUSTOMER;

@Repository
@AllArgsConstructor
class CustomerRepository {
    private DSLContext dslContext;

    List<Customer> findAll() {
        return dslContext.selectFrom(CUSTOMER)
                .fetchInto(Customer.class);
    }

    void insert(Customer customer) {
        dslContext.newRecord(CUSTOMER, customer)
                .insert();
    }

    void deleteAll() {
        dslContext.deleteFrom(CUSTOMER)
            .execute();
    }
}
