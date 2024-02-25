package com.java17.utilityprograms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@SpringBootApplication
public class GetEpochTImeApplication {
    public static void main(String[] args) throws ParseException {
        SpringApplication.run(GetEpochTImeApplication.class, args);
        System.out.println(getEpochTIme());
    }

    public static Long getEpochTIme() throws ParseException {
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd yyyy HH:mm:ss.SSS zzz");
        String currentTime = simpleDateFormat.format(today);
        Date date = simpleDateFormat.parse(currentTime);
        long epochTime = date.getTime();
        return epochTime;
    }
}
