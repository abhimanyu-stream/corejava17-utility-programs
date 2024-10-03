package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MaskUPICodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaskUPICodeApplication.class, args);
        System.out.println(maskUPICode("some.example@okhdfc"));

        System.out.println(maskingUPICode("some.example@okhdfc"));

    }

    public static String maskUPICode(String upiCode) {
        if(upiCode == null) {
            return null;
        }
        return upiCode.substring(0,upiCode.lastIndexOf("@")).replaceAll("\\S", "*")+upiCode.substring(upiCode.lastIndexOf("@"));
    }

    public static String maskingUPICode(String upiCode) {
        // Assuming UPI code is alphanumeric (letters and digits)
        int lengthToMask = (int) (upiCode.length() * 0.75); // Mask 75% of the code

        // Iff The UPI ID contains A_Z, a-z,0-9, ., -, _
        // Otherwise you remove - and _ from regex pattern below if not allowed in UPI ID creation
        String maskedPart = upiCode.substring(0, lengthToMask).replaceAll("[A-Za-z0-9.-_]", "X");
        return maskedPart + upiCode.substring(lengthToMask);
    }
}
