package com.jooq.examples.domain.customer

import static org.assertj.core.api.Assertions.assertThat

class CustomerQueryPortTest extends CustomerAbstractTest {

    def "select all customers test should return zero records"() {
        given:
        when:
            List<Customer> customers = customerQueryPort.findAll()
        then:
            customers.size() == 0
    }

    def "select by id should return one record"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            Customer customer = customerQueryPort.findById(2)
        then:
            customer != null
            customer.id == 2
    }

    def "select by id should not return record"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            customerQueryPort.findById(6)
        then:
            def exception = thrown(NoSuchElementException)
            exception.message == "Not found customer by id 6"
    }

    def "select customer by name should return two records"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            List<Customer> foundCustomers = customerQueryPort.findByFirstName("Bob")
        then:
            foundCustomers.size() == 2
            assertThat(foundCustomers).extracting("id").contains(1, 4)
    }

    def "select customer by name should not return record"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            List<Customer> foundCustomers = customerQueryPort.findByFirstName("Abi")
        then:
            foundCustomers.isEmpty()
    }
}
