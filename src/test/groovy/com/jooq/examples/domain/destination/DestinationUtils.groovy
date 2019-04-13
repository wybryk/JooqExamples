package com.jooq.examples.domain.destination

class DestinationUtils {
    static def buildDestination() {
        return Destination.builder()
            .id(1)
            .country("POLAND")
            .build()
    }
}
