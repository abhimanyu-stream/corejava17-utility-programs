package com.java17.utilityprograms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistributorIDApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributorIDApplication.class, args);
        System.out.println("Distributor ID: " + getDistributorID());

    }
    public static long getDistributorID() {
        // 12 digits.

        long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 13));
        //inc = (inc + 1) % 10;
        return id;
    }
}
