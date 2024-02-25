package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;

@SpringBootApplication
public class TimestampApplication {

    public static void main(String[] args) {

        SpringApplication.run(TimestampApplication.class, args);
        System.out.println(getTimestamp());
    }
    public static Instant getTimestamp() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Instant instant = timestamp.toInstant();

        return instant;
    }
}
