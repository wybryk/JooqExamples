package com.jooq.examples.domain.destination;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Destination {
    private Integer id;
    private String country;
}
