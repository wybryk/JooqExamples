package com.jooq.examples.application.configuration;

import org.jooq.Converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements Converter<Timestamp, LocalDateTime> {
    private static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    @Override
    public LocalDateTime from(Timestamp timestamp) {
        return timestamp == null ? null : timestamp.toLocalDateTime();
    }

    @Override
    public Timestamp to(LocalDateTime localDateTime) {
        return localDateTime == null ? null : Timestamp.valueOf(localDateTime.format(DateTimeFormatter.ofPattern(PATTERN)));
    }

    @Override
    public Class<Timestamp> fromType() {
        return Timestamp.class;
    }

    @Override
    public Class<LocalDateTime> toType() {
        return LocalDateTime.class;
    }
}
