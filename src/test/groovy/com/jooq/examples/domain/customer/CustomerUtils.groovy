package com.jooq.examples.domain.customer

class CustomerUtils {
    static def buildCustomers() {
        return Arrays.asList(
                buildCustomer(1, "Bob", "Pure"),
                buildCustomer(2, "Alfie", "Nelson"),
                buildCustomer(3, "Gordon", "Pure"),
                buildCustomer(4, "Bob", "Adams"),
                buildCustomer(5, "John", "Parker")
        )
    }

    static def buildCustomer(Integer id, String firstName, String lastName) {
        return Customer.builder()
            .id(id)
            .firstName(firstName)
            .lastName(lastName)
            .build()
    }
}
