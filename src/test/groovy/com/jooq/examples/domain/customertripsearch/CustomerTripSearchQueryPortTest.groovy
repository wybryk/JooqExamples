package com.jooq.examples.domain.customertripsearch

import com.jooq.examples.JooqExamplesApplication
import com.jooq.examples.domain.customer.Customer
import com.jooq.examples.domain.customer.CustomerUtils
import com.jooq.examples.domain.customer.port.CustomerCommandPort
import com.jooq.examples.domain.customertrip.CustomerTrip
import com.jooq.examples.domain.customertrip.CustomerTripUtils
import com.jooq.examples.domain.customertrip.port.CustomerTripCommandPort
import com.jooq.examples.domain.customertripsearch.port.CustomerTripSearchQueryPort
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

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class CustomerTripSearchQueryPortTest extends Specification {
    @Autowired private CustomerTripSearchQueryPort customerTripSearchQueryPort
    @Autowired private CustomerTripCommandPort customerTripCommandPort
    @Autowired private TripCommandPort tripCommandPort
    @Autowired private DestinationCommandPort destinationCommandPort
    @Autowired private CustomerCommandPort customerCommandPort

    def setup() {
        List<Destination> destinations = DestinationUtils.buildDestinations()
        destinationCommandPort.insertAll(destinations)
        List<Trip> trips = TripUtils.buildTrips(destinations)
        tripCommandPort.insertAll(trips)
        List<Customer> customers = CustomerUtils.buildCustomers()
        customerCommandPort.insertAll(customers)
        List<CustomerTrip> customerTrips = CustomerTripUtils.buildCustomerTrips(trips, customers)
        customerTripCommandPort.insertAll(customerTrips)
    }

    def cleanup() {
        customerTripCommandPort.deleteAll()
        customerCommandPort.deleteAll()
        tripCommandPort.deleteAll()
        destinationCommandPort.deleteAll()
    }

    def "customer trip search find all test should find ten records"() {
        given:
        when:
            List<CustomerTripSearch> result = customerTripSearchQueryPort.findAll()
        then:
            result.size() == 10
    }
}
