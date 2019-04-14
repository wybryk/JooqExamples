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

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class CustomerTripCommandPortTest extends Specification {
    @Autowired private CustomerTripCommandPort customerTripCommandPort
    @Autowired private CustomerTripQueryPort customerTripQueryPort
    @Autowired private TripCommandPort tripCommandPort
    @Autowired private DestinationCommandPort destinationCommandPort
    @Autowired private CustomerCommandPort customerCommandPort
    private List<Trip> trips
    private List<Destination> destinations
    private List<Customer> customers

    def setup() {
        destinations = DestinationUtils.buildDestinations()
        destinationCommandPort.insertAll(destinations)
        trips = TripUtils.buildTrips(destinations)
        tripCommandPort.insertAll(trips)
        customers = CustomerUtils.buildCustomers()
        customerCommandPort.insertAll(customers)
    }

    def cleanup() {
        customerTripCommandPort.deleteAll()
        tripCommandPort.deleteAll()
        destinationCommandPort.deleteAll()
        customerCommandPort.deleteAll()
    }

    def "customer trip insert test"() {
        given:
            CustomerTrip customerTrip = CustomerTripUtils.buildCustomerTrip(1, LocalDate.of(2019, 4, 13),
                    LocalDateTime.of(2019, 4, 13, 15, 54), trips.get(0), customers.get(0))
        when:
            customerTripCommandPort.insert(customerTrip)
        then:
            List<CustomerTrip> customerTripList = customerTripQueryPort.findAll()
            customerTripList.size() == 1
            customerTripList.get(0).getId() == 1
            customerTripList.get(0).getCustomerId() == customers.get(0).getId()
            customerTripList.get(0).getTripId() == trips.get(0).getId()
            customerTripList.get(0).getStartDate() == LocalDate.of(2019, 4, 13)
            customerTripList.get(0).getInsertionTime() == LocalDateTime.of(2019, 4, 13, 15, 54)
    }

    def "customer trip list insert test should return ten records"() {
        given:
            List<CustomerTrip> customerTrips = CustomerTripUtils.buildCustomerTrips(trips, customers)
        when:
            customerTripCommandPort.insertAll(customerTrips)
        then:
            List<CustomerTrip> foundCustomerTripss = customerTripQueryPort.findAll()
            foundCustomerTripss.size() == 10
            assertThat(foundCustomerTripss).extracting("id").contains(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    }
}
