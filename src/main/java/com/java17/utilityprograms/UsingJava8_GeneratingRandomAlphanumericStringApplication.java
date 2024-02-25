package com.java17.utilityprograms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;


@SpringBootApplication
public class UsingJava8_GeneratingRandomAlphanumericStringApplication {
    public static void main(String[] args) {
        SpringApplication.run(UsingJava8_GeneratingRandomAlphanumericStringApplication.class, args);
        System.out.println("Using Java 8: Generating Random Alphanumeric String: " + UsingJava8_GeneratingRandomAlphanumericString());
    }

    public static String UsingJava8_GeneratingRandomAlphanumericString() {
        //The ASCII value of the lowercase alphabet is from 97 to 122. And, the ASCII value of the uppercase alphabet is from 65 to 90.
        //It can be observed that ASCII value of digits [0 – 9] ranges from [48 – 57].
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }
}
