package com.jooq.examples.domain.customer;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
