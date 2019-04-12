package com.jooq.examples.domain.customer;

import com.jooq.examples.testdb.public_.tables.records.CustomerRecord;
import lombok.AllArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.InsertValuesStep3;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.NoSuchElementException;

import static com.jooq.examples.testdb.public_.tables.Customer.CUSTOMER;

@Repository
@AllArgsConstructor
class CustomerRepository {
    private DSLContext dslContext;

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


    void deleteById(Integer id) {
        dslContext.deleteFrom(CUSTOMER)
                .where(CUSTOMER.ID.eq(id))
                .execute();
    }

    void update(Customer customer) {
        dslContext.update(CUSTOMER)
                .set(CUSTOMER.FIRST_NAME, customer.getFirstName())
                .set(CUSTOMER.LAST_NAME, customer.getLastName())
                .where(CUSTOMER.ID.eq(customer.getId()))
                .execute();
    }

    List<Customer> findAll() {
        return dslContext.selectFrom(CUSTOMER)
                .fetchInto(Customer.class);
    }

    Customer findById(Integer id) {
        return dslContext.selectFrom(CUSTOMER)
                .where(CUSTOMER.ID.eq(id))
                .fetch()
                .stream()
                .findFirst()
                .map(record -> record.into(Customer.class))
                .orElseThrow(() -> new NoSuchElementException("Not found customer by id " + id));
    }

    List<Customer> findByFirstName(String firstName) {
        return dslContext.selectFrom(CUSTOMER)
                .where(CUSTOMER.FIRST_NAME.eq(firstName))
                .fetchInto(Customer.class);
    }
}
