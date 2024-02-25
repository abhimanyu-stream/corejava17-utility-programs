package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class RandomNumberForOTPApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomNumberForOTPApplication.class, args);
        System.out.println(randomNumberForOTP(4));
    }

    public static String randomNumberForOTP(int sizeOfOtp) {

        String numbers = "0123456789";
        Random random = new Random();
        char[] otp = new char[sizeOfOtp];
        for (int i = 0; i < sizeOfOtp; i++) {
            otp[i] = numbers.charAt(random.nextInt(numbers.length()));
        }
        return new String(otp);
    }
}
