package com.jooq.examples.domain.trip;

import com.jooq.examples.domain.enums.TransportType;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;

@Value
@Builder
public class Trip {
    private Integer id;
    private String title;
    private TransportType transportType;
    private Integer duration;
    private BigDecimal price;
    private Integer destinationId;
}
