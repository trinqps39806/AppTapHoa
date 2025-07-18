package com.example.apptaphoa.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm:ss";

    public static String formatDate(Date date) {
        return new SimpleDateFormat(DATE_FORMAT).format(date);
    }

    public static String formatDateTime(Date date) {
        return new SimpleDateFormat(DATETIME_FORMAT).format(date);
    }

    public static Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }
}
