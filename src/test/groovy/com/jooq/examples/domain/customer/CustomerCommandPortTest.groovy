package com.jooq.examples.domain.customer

import static org.assertj.core.api.Assertions.assertThat

class CustomerCommandPortTest extends CustomerAbstractTest {

    def "insert customer test should return one record"() {
        given:
            Customer customer = CustomerUtils.buildCustomer(1, "Bob", "Pure")
        when:
            customerCommandPort.insert(customer)
        then:
            List<Customer> customers = customerQueryPort.findAll()
            customers.size() == 1
            customers.get(0).id == 1
    }

    def "insert customer list test should return five records"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
        when:
            customerCommandPort.insertAll(customers)
        then:
            List<Customer> foundCustomers = customerQueryPort.findAll()
            foundCustomers.size() == 5
            assertThat(foundCustomers).extracting("id").contains(1, 2, 3, 4, 5)
    }

    def "delete all customers should not return records"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            customerCommandPort.deleteAll()
        then:
            List<Customer> foundCustomers = customerQueryPort.findAll()
            foundCustomers.size() == 0
    }

    def "delete by id customer should return four records"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            customerCommandPort.deleteById(4)
        then:
            List<Customer> foundCustomers = customerQueryPort.findAll()
            foundCustomers.size() == 4
    }

    def "update customer test"() {
        given:
            List<Customer> customers = CustomerUtils.buildCustomers()
            customerCommandPort.insertAll(customers)
        when:
            Customer customer = CustomerUtils.buildCustomer(3, "Gordon", "Dirt")
            customerCommandPort.update(customer)
        then:
            Customer foundCustomer = customerQueryPort.findById(3)
            foundCustomer.getId() == 3
            foundCustomer.getFirstName() == "Gordon"
            foundCustomer.getLastName() == "Dirt"
    }
}
