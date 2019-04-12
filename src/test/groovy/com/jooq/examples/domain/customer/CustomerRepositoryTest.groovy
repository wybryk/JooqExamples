package com.jooq.examples.domain.customer

import com.jooq.examples.JooqExamplesApplication
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class CustomerRepositoryTest extends Specification {
    @Autowired
    private CustomerRepository customerRepository
    private CustomerUtils customerUtils

    def setup() {
        customerUtils = new CustomerUtils()
    }

    def cleanup() {
        customerRepository.deleteAll()
    }

    def "select all customers test should return zero"() {
        given:
        when:
            List<Customer> customers = customerRepository.findAll()
        then:
            customers.size() == 0
    }

    def "insert customer test should return one record"() {
        given:
            Customer customer = customerUtils.buildCustomer(1, "Bob", "Pure")
        when:
            customerRepository.insert(customer)
            List<Customer> customers = customerRepository.findAll()
        then:
            customers.size() == 1
            customers.get(0).id == 1
    }

    def "insert customer list test should return five records"() {
        given:
            List<Customer> customers = new ArrayList<>()
            customers.add(customerUtils.buildCustomer(1, "Bob", "Pure"))
            customers.add(customerUtils.buildCustomer(2, "Alfie", "Nelson"))
            customers.add(customerUtils.buildCustomer(3, "Gordon", "Pure"))
            customers.add(customerUtils.buildCustomer(4, "Bob", "Adams"))
            customers.add(customerUtils.buildCustomer(5, "John", "Parker"))
        when:
            customerRepository.insertAll(customers)
            List<Customer> foundCustomers = customerRepository.findAll()
        then:
            customers.size() == 5
            assertThat(foundCustomers).extracting("id").contains(1, 2, 3, 4, 5)
    }
}
