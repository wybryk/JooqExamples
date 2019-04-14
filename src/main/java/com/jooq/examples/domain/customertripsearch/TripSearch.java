package com.jooq.examples.domain.customertripsearch;

import com.jooq.examples.domain.enums.TransportType;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class TripSearch {
    private Integer id;
    private String title;
    private TransportType transportType;
    private Integer duration;
    private BigDecimal price;
    private DestinationSearch destination;
}
