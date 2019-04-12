package com.jooq.examples.domain.customer

class CustomerUtils {
    static def buildCustomer(Integer id, String firstName, String lastName) {
        return Customer.builder()
            .id(id)
            .firstName(firstName)
            .lastName(lastName)
            .build()
    }
}
