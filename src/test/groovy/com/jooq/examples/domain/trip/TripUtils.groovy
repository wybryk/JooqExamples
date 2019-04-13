package com.jooq.examples.domain.trip

import com.jooq.examples.domain.destination.Destination
import com.jooq.examples.domain.enums.TransportType


class TripUtils {
    static def buildTrip(Destination destination) {
        return Trip.builder()
            .id(5)
            .title("Travel around Poland")
            .transportType(TransportType.CAR)
            .duration(30)
            .price(new BigDecimal(5000))
            .destinationId(destination.getId())
            .build()
    }
}
