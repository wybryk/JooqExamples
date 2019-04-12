package com.jooq.examples.domain.customer;

import com.jooq.examples.testdb.public_.tables.records.CustomerRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep3;
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

    void insertAll(List<Customer> customers) {
        InsertValuesStep3<CustomerRecord, Integer, String, String> step =
                dslContext.insertInto(CUSTOMER, CUSTOMER.ID, CUSTOMER.FIRST_NAME, CUSTOMER.LAST_NAME);
        customers.forEach(customer -> step.values(customer.getId(), customer.getFirstName(), customer.getLastName()));
        step.execute();
    }

    void deleteAll() {
        dslContext.deleteFrom(CUSTOMER)
            .execute();
    }
}
