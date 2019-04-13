package com.jooq.examples.domain.destination.port;

import com.jooq.examples.domain.destination.Destination;

public interface DestinationCommandPort {
    void insert(Destination destination);
    void deleteAll();
}
