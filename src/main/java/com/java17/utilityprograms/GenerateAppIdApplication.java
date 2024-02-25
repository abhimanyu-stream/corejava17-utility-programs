package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class GenerateAppIdApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateAppIdApplication.class, args);
        System.out.println(generateAppId());
    }

    public static String generateAppId() {

        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString().replace("-", "");

        return uuidAsString;
    }
}
