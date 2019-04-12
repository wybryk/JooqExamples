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

    def cleanup() {
        customerRepository.deleteAll()
    }

    def "select all customers test should return zero"() {
        given:
        when:
            List<Customer> customers = customerRepository.findAll()
        then:
            assertThat(customers.size()).isZero()
    }

    def "insert customer test should return one"() {
        given:
            Customer customer = Customer.builder()
                .id(1)
                .firstName("Bob")
                .lastName("Pure")
                .build()
        when:
            customerRepository.insert(customer)
            List<Customer> customers = customerRepository.findAll()
        then:
            assertThat(customers.size()).isOne()
            assertThat(customers.get(0).id).isEqualTo(1)
    }

}
