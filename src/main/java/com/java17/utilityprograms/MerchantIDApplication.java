package com.java17.utilityprograms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MerchantIDApplication {

    public static void main(String[] args) {
        SpringApplication.run(MerchantIDApplication.class, args);
        System.out.println("Merchant ID: " + getMerchantID());

    }
    public static long getMerchantID() {
        // 12 digits.

        long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 13));
        //inc = (inc + 1) % 10;
        return id;
    }
}
