package com.enigma.tarkam.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class DateUtil {
    public static Date stringToDate(String format, String sDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(sDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
