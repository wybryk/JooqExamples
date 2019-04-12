package com.jooq.examples.domain.customer

import com.jooq.examples.JooqExamplesApplication
import com.jooq.examples.domain.customer.port.CustomerCommandPort
import com.jooq.examples.domain.customer.port.CustomerQueryPort
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

@SpringBootTest(classes = JooqExamplesApplication)
@ContextConfiguration
class CustomerAbstractTest extends Specification {
    @Autowired protected CustomerCommandPort customerCommandPort
    @Autowired protected CustomerQueryPort customerQueryPort

    def cleanup() {
        customerCommandPort.deleteAll()
    }
}
