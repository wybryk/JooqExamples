package com.jooq.examples.domain.customertripsearch;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerSearch {
    private Integer id;
    private String firstName;
    private String lastName;
}
