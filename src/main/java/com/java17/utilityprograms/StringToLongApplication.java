package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StringToLongApplication {


    public static void main(String[] args) {
        SpringApplication.run(StringToLongApplication.class, args);
        System.out.println("String to Long: " + StringToLong("1234"));
    }
    public static long StringToLong (String numberAsString) {

        long longValue1 = 0;
        long longvalue2 ;
        try {
            longValue1 = Long.parseLong(numberAsString);
            longvalue2 = Long.valueOf(numberAsString).longValue();
            System.out.println("long value1 is  = " + longValue1);
            System.out.println("long value2 is  = " + longvalue2);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: " + e.getMessage());
        }
        //return longvalue2;
        return longValue1;
    }
}
