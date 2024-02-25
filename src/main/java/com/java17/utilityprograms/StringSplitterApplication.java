package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class StringSplitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(StringSplitterApplication.class, args);
        System.out.println(Arrays.toString(functionSplit("1,2,3,4,5", ",")));
        System.out.println(Arrays.toString(functionSplit("Welcome,to,the,world,of,technology", ",")));
        System.out.println(Arrays.toString(functionSplit("strem@gmail.com", "@")));
    }

    public static String[] functionSplit(String str, String seperator) {

        String[] result = str.split(seperator);
        return result;
    }


}
