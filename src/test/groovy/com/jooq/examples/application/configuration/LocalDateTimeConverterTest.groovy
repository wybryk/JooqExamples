package com.jooq.examples.application.configuration

import com.jooq.examples.JooqExamplesApplication
import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

import java.sql.Timestamp
import java.time.LocalDateTime

@SpringBootTest(classes = JooqExamplesApplication)
class LocalDateTimeConverterTest extends Specification {
    private LocalDateTimeConverter localDateTimeConverter = new LocalDateTimeConverter()

    def "timestamp to localDateTime convert test when value is null"() {
        given:
            Timestamp time = null
        when:
            LocalDateTime result = localDateTimeConverter.from(time)
        then:
            result == null
    }

    def "timestamp to localDateTime convert test"() {
        given:
            Timestamp time = new Timestamp(1555436914000)
        when:
            LocalDateTime result = localDateTimeConverter.from(time)
        then:
            result == LocalDateTime.of(2019, 4, 16, 19, 48, 34)
    }

    def "localDate to timestamp convert test when value is null"() {
        given:
            LocalDateTime date = null
        when:
            Timestamp result = localDateTimeConverter.to(date)
        then:
            result == null
    }

    def "localDate to timestamp convert test"() {
        given:
            LocalDateTime date = LocalDateTime.of(2019, 4, 16, 19, 48, 34)
        when:
            Timestamp result = localDateTimeConverter.to(date)
        then:
            result == new Timestamp(1555436914000)
    }

    def "timestamp class type convert test"() {
        when:
            Class type = localDateTimeConverter.fromType()
        then:
            type == Timestamp.class
    }

    def "localDateTime class type convert test"() {
        when:
            Class type = localDateTimeConverter.toType()
        then:
            type == LocalDateTime.class
    }
}
