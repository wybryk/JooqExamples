package com.jooq.examples.application.configuration;

import org.jooq.Converter;

import java.sql.Date;
import java.time.LocalDate;

public class LocalDateConverter implements Converter<Date, LocalDate> {
    @Override
    public LocalDate from(Date date) {
        return date == null ? null : LocalDate.parse(date.toString());
    }

    @Override
    public Date to(LocalDate localDate) {
        return localDate == null ? null : Date.valueOf(localDate.toString());
    }

    @Override
    public Class<Date> fromType() {
        return Date.class;
    }

    @Override
    public Class<LocalDate> toType() {
        return LocalDate.class;
    }
}
