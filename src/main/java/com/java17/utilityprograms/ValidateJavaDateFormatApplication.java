package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class ValidateJavaDateFormatApplication {

    public static void main(String[] args) {
        SpringApplication.run(ValidateJavaDateFormatApplication.class, args);
        System.out.println("Validate Java Date Format: " + validateJavaDateFormat("2020-02-01"));
    }
    public static boolean validateJavaDateFormat(String strDate){

        /*Set preferred date format,For example yyyy-mm-dd*/

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        simpleDateFormat.setLenient(false);
        //Create Date object parse the string into date
        //If a string will be converted into a date object then string is valid and contain a valid date value in desire format
        try {
            Date javaDate = simpleDateFormat.parse(strDate.trim());
            System.out.println(strDate + " is valid date format  : "+ javaDate);
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }


        return true;
    }
}
