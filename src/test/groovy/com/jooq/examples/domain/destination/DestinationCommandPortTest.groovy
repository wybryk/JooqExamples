package com.jooq.examples.domain.destination

import com.jooq.examples.JooqExamplesApplication
import com.jooq.examples.domain.destination.port.DestinationCommandPort
import com.jooq.examples.domain.destination.port.DestinationQueryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import static org.assertj.core.api.Assertions.assertThat

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class DestinationCommandPortTest extends Specification {
    @Autowired private DestinationCommandPort destinationCommandPort
    @Autowired private DestinationQueryPort destinationQueryPort

    def cleanup() {
        destinationCommandPort.deleteAll()
    }

    def "destination insert test"() {
        given:
            Destination destination = DestinationUtils.buildDestination(1, "POLAND")
        when:
            destinationCommandPort.insert(destination)
        then:
            List<Destination> foundDestinations = destinationQueryPort.findAll()
            foundDestinations.size() == 1
            foundDestinations.get(0).getId() == 1
            foundDestinations.get(0).getCountry() == "POLAND"
    }

    def "destination list insert test should return three records"() {
        given:
            List<Destination> destinations = DestinationUtils.buildDestinations()
        when:
            destinationCommandPort.insertAll(destinations)
        then:
            List<Destination> foundDestinations = destinationQueryPort.findAll()
            foundDestinations.size() == 3
            assertThat(foundDestinations).extracting("id").contains(1, 2, 3)
    }
}
