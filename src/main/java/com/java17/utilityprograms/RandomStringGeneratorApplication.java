package com.java17.utilityprograms;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

import java.nio.charset.Charset;
import java.util.Random;

@SpringBootApplication
public class RandomStringGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(RandomStringGeneratorApplication.class, args);

        int n = 20;
        System.out.println(getAlphaNumericString1(n));
        System.out.println(getAlphaNumericString2(n));
    }


    static String getAlphaNumericString1(int n) {
        byte[] array = new byte[256];
        new Random().nextBytes(array);
        String randomString = new String(array, Charset.forName("UTF-8"));
        StringBuffer r = new StringBuffer();
        for (int k = 0; k < randomString.length(); k++) {
            char ch = randomString.charAt(k);
            if (((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) && (n > 0)) {
                r.append(ch);
                n--;
            }
        }
        return r.toString();
    }
    static String getAlphaNumericString2(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                "0123456789" +
                "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }


}
