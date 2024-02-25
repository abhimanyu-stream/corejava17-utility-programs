package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.regex.Pattern;

@SpringBootApplication
public class IFSCValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IFSCValidatorApplication.class, args);
        String validCode1 = "SBIN0125620"; // Valid IFSC code
        String validCode2 = "HDFC0001234"; // Valid IFSC code
        String invalidCode1 = "SBIN0125"; // Invalid IFSC code (short length)
        String invalidCode2 = "1234SBIN012"; // Invalid IFSC code (doesn't start with alphabets)

        System.out.println("Valid code 1: " + isValidIFSCCode(validCode1)); // true
        System.out.println("Valid code 2: " + isValidIFSCCode(validCode2)); // true
        System.out.println("Invalid code 1: " + isValidIFSCCode(invalidCode1)); // false
        System.out.println("Invalid code 2: " + isValidIFSCCode(invalidCode2)); // false

    }

    public static boolean isValidIFSCCode(String str) {
        String regex = "^[A-Z]{4}0[A-Z0-9]{6}$";
        return Pattern.matches(regex, str);
    }
}
