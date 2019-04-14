package com.jooq.examples.domain.destination

class DestinationUtils {
    static def buildDestinations() {
        return Arrays.asList(
                buildDestination(1, "POLAND"),
                buildDestination(2, "ITALY"),
                buildDestination(3, "GREECE")
        )
    }

    static def buildDestination(Integer id, String country) {
        return Destination.builder()
            .id(id)
            .country(country)
            .build()
    }
}
