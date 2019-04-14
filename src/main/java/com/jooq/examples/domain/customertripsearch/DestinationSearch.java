package com.jooq.examples.domain.customertripsearch;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class DestinationSearch {
    private Integer id;
    private String country;
}
