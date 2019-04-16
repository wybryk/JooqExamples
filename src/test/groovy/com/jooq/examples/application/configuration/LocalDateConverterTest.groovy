package com.jooq.examples.application.configuration

import com.jooq.examples.JooqExamplesApplication
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.sql.Date
import java.time.LocalDate

@SpringBootTest(classes = JooqExamplesApplication)
class LocalDateConverterTest extends Specification {
    private LocalDateConverter localDateConverter = new LocalDateConverter()

    def "date to localDate convert test when value is null"() {
        given:
            Date date = null
        when:
            LocalDate result = localDateConverter.from(date)
        then:
            result == null
    }

    def "date to localDate convert test"() {
        given:
            Date date = new Date(1555365600000)
        when:
            LocalDate result = localDateConverter.from(date)
        then:
            result == LocalDate.of(2019, 4, 16)
    }

    def "localDate to date convert test when value is null"() {
        given:
            LocalDate date = null
        when:
            Date result = localDateConverter.to(date)
        then:
            result == null
    }

    def "localDate to date convert test"() {
        given:
            LocalDate date = LocalDate.of(2019, 4, 16)
        when:
            Date result = localDateConverter.to(date)
        then:
            result == new Date(1555365600000)
    }

    def "date class type convert test"() {
        when:
            Class type = localDateConverter.fromType()
        then:
            type == Date.class
    }

    def "localDate class type convert test"() {
        when:
            Class type = localDateConverter.toType()
        then:
            type == LocalDate.class
    }
}
