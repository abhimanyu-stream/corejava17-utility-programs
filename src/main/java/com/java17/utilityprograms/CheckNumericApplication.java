package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckNumericApplication {

    public static void main(String[] args) {

        SpringApplication.run(CheckNumericApplication.class, args);

        System.out.println(isNumericPositiveOrNegative(null)); // false
        System.out.println(isNumericPositiveOrNegative("-1234.15")); // false
        System.out.println(isNumericPositiveOrNegative("1234.15")); // true
        System.out.println(isNumericPositiveOrNegative("234")); // true
        System.out.println(isNumericPositiveOrNegative("1234.15.15")); // false




        System.out.println(isNumericPositiveOnly(null)); // false
        System.out.println(isNumericPositiveOnly("-1234.15")); // false
        System.out.println(isNumericPositiveOnly("1234.15")); // true
        System.out.println(isNumericPositiveOnly("234")); // true
        System.out.println(isNumericPositiveOnly("1234.15.15")); // false




    }
        //    -? allows zero or more hyphens for negative numbers.
        //   \d+ checks that the string has at least one or more digits.
        //   (\\.\\d+)? allows zero or more decimal points followed by digits.
    public static boolean isNumericPositiveOrNegative(String str) {
        if (str == null)
            return false;
        return str.matches("-?\\d+(\\.\\d+)?");


    }
    public static boolean isNumericPositiveOnly(String str) {
        if (str == null)
            return false;
        return str.matches("\\d+(\\.\\d+)?");


    }
}
