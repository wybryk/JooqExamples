package com.jooq.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class JooqExamplesApplication {
    public static void main(String[] args) {
        SpringApplication.run(JooqExamplesApplication.class, args);
    }
}
