package com.jooq.examples.domain.trip

import com.jooq.examples.domain.destination.Destination
import com.jooq.examples.domain.enums.TransportType


class TripUtils {
    static def buildTrips(List<Destination> destinations) {
        return Arrays.asList(
                buildTrip(1, "Travel around Poland",
                        TransportType.CAR, 30, new BigDecimal(5000), destinations.get(0)),
                buildTrip(2, "Travel to Rome",
                        TransportType.PLANE, 7, new BigDecimal(4999), destinations.get(1)),
                buildTrip(3, "Travel to Athens",
                        TransportType.CAR, 14, new BigDecimal(7058), destinations.get(2)),
                buildTrip(4, "Cruise",
                        TransportType.SHIP, 1, new BigDecimal(100), destinations.get(2)),
                buildTrip(5, "Bike trip",
                        TransportType.BIKE, 2, new BigDecimal(499), destinations.get(0))
        )
    }

    static def buildTrip(Integer id, String title, TransportType transportType, Integer duration, BigDecimal price,
                         Destination destination) {
        return Trip.builder()
                .id(id)
                .title(title)
                .transportType(transportType)
                .duration(duration)
                .price(price)
                .destinationId(destination.getId())
                .build()
    }
}
