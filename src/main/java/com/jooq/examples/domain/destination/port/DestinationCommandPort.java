package com.jooq.examples.domain.destination.port;

import com.jooq.examples.domain.destination.Destination;

import java.util.List;

public interface DestinationCommandPort {
    void insert(Destination destination);
    void insertAll(List<Destination> destinations);
    void deleteAll();
}
