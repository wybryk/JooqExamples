package com.jooq.examples.domain.customertrip

import com.jooq.examples.JooqExamplesApplication
import com.jooq.examples.domain.customer.Customer
import com.jooq.examples.domain.customer.CustomerUtils
import com.jooq.examples.domain.customer.port.CustomerCommandPort
import com.jooq.examples.domain.customertrip.port.CustomerTripCommandPort
import com.jooq.examples.domain.customertrip.port.CustomerTripQueryPort
import com.jooq.examples.domain.destination.Destination
import com.jooq.examples.domain.destination.DestinationUtils
import com.jooq.examples.domain.destination.port.DestinationCommandPort
import com.jooq.examples.domain.trip.Trip
import com.jooq.examples.domain.trip.TripUtils
import com.jooq.examples.domain.trip.port.TripCommandPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDate
import java.time.LocalDateTime

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class CustomerTripCommandPortTest extends Specification {
    @Autowired private CustomerTripCommandPort customerTripCommandPort
    @Autowired private CustomerTripQueryPort customerTripQueryPort
    @Autowired private TripCommandPort tripCommandPort
    @Autowired private DestinationCommandPort destinationCommandPort
    @Autowired private CustomerCommandPort customerCommandPort
    private Trip trip
    private Destination destination
    private Customer customer

    def setup() {
        destination = DestinationUtils.buildDestination()
        destinationCommandPort.insert(destination)
        trip = TripUtils.buildTrip(destination)
        tripCommandPort.insert(trip)
        customer = CustomerUtils.buildCustomer(1, "Alfie", "Logan")
        customerCommandPort.insert(customer)
    }

    def cleanup() {
        customerTripCommandPort.deleteAll()
        tripCommandPort.deleteAll()
        destinationCommandPort.deleteAll()
        customerCommandPort.deleteAll()
    }

    def "customer trip insert test"() {
        given:
            CustomerTrip customerTrip = CustomerTripUtils.buildCustomerTrip(trip, customer)
        when:
            customerTripCommandPort.insert(customerTrip)
        then:
            List<CustomerTrip> customerTripList = customerTripQueryPort.findAll()
            customerTripList.size() == 1
            customerTripList.get(0).getId() == 1
            customerTripList.get(0).getCustomerId() == customer.getId()
            customerTripList.get(0).getTripId() == trip.getId()
            customerTripList.get(0).getStartDate() == LocalDate.of(2019, 4, 13)
            customerTripList.get(0).getInsertionTime() == LocalDateTime.of(2019, 4, 13, 15, 54)
    }
}
