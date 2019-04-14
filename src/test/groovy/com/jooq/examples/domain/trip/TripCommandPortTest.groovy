package com.jooq.examples.domain.trip

import com.jooq.examples.JooqExamplesApplication
import com.jooq.examples.domain.destination.Destination
import com.jooq.examples.domain.destination.DestinationUtils
import com.jooq.examples.domain.destination.port.DestinationCommandPort
import com.jooq.examples.domain.enums.TransportType
import com.jooq.examples.domain.trip.port.TripCommandPort
import com.jooq.examples.domain.trip.port.TripQueryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class TripCommandPortTest extends Specification {
    @Autowired private TripCommandPort tripCommandPort
    @Autowired private TripQueryPort tripQueryPort
    @Autowired private DestinationCommandPort destinationCommandPort
    private List<Destination> destinations

    def setup() {
        destinations = DestinationUtils.buildDestinations()
        destinationCommandPort.insertAll(destinations)
    }

    def cleanup() {
        tripCommandPort.deleteAll()
        destinationCommandPort.deleteAll()
    }

    def "trip insert test"() {
        given:
            Trip trip = TripUtils.buildTrip(1, "Travel around Poland", TransportType.CAR, 30,
                    new BigDecimal(5000), destinations.get(0))
        when:
            tripCommandPort.insert(trip)
        then:
            List<Trip> foundTrips = tripQueryPort.findAll()
            foundTrips.size() == 1
            foundTrips.get(0).getId() == 1
            foundTrips.get(0).getTitle() == "Travel around Poland"
            foundTrips.get(0).getTransportType() == TransportType.CAR
            foundTrips.get(0).getDuration() == 30
            foundTrips.get(0).getPrice() == new BigDecimal(5000)
            foundTrips.get(0).getDestinationId() == destinations.get(0).getId()
    }

    def "trip list insert test should return five records"() {
        given:
            List<Trip> trips = TripUtils.buildTrips(destinations)
        when:
            tripCommandPort.insertAll(trips)
        then:
            List<Trip> foundTrips = tripQueryPort.findAll()
            foundTrips.size() == 5
            assertThat(foundTrips).extracting("id").contains(1, 2, 3, 4, 5)
    }
}
