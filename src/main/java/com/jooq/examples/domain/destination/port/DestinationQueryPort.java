package com.jooq.examples.domain.destination.port;

import com.jooq.examples.domain.destination.Destination;

import java.util.List;

public interface DestinationQueryPort {
    List<Destination> findAll();
}
