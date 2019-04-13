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

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class TripCommandPortTest extends Specification {
    @Autowired private TripCommandPort tripCommandPort
    @Autowired private TripQueryPort tripQueryPort
    @Autowired private DestinationCommandPort destinationCommandPort
    private Destination destination

    def setup() {
        destination = DestinationUtils.buildDestination()
        destinationCommandPort.insert(destination)
    }

    def cleanup() {
        tripCommandPort.deleteAll()
        destinationCommandPort.deleteAll()
    }

    def "trip insert test"() {
        given:
            Trip trip = TripUtils.buildTrip(destination)
        when:
            tripCommandPort.insert(trip)
        then:
            List<Trip> foundTrips = tripQueryPort.findAll()
            foundTrips.size() == 1
            foundTrips.get(0).getId() == 5
            foundTrips.get(0).getTitle() == "Travel around Poland"
            foundTrips.get(0).getTransportType() == TransportType.CAR
            foundTrips.get(0).getDuration() == 30
            foundTrips.get(0).getPrice() == new BigDecimal(5000)
            foundTrips.get(0).getDestinationId() == destination.getId()
    }
}
