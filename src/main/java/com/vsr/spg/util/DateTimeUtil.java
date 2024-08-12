package com.vsr.spg.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DateTimeUtil {

    private static final Map<Locale, SimpleDateFormat> localeToFormatter;

    public static final String DATE_TIME_FORMAT = "MM/dd/yyyy HH:mm:ss";

    static {
        localeToFormatter = new HashMap<>();
        localeToFormatter.put(Locale.getDefault(), new SimpleDateFormat(DATE_TIME_FORMAT));
    }

    /**
     * Format the datetime
     *
     * @param timestamp input time
     * @return formatted date time
     */
    public static String formatDateTime(Timestamp timestamp) {
        return formatDateTime(Locale.getDefault(), timestamp);
    }

    /**
     * Format the datetime
     *
     * @param locale    selected locale
     * @param timestamp input time
     * @return formatted date time
     */
    public static String formatDateTime(Locale locale, Timestamp timestamp) {
        if (timestamp == null) {
            return null;
        }

        if (locale == null) {
            locale = Locale.getDefault();
        }

        return localeToFormatter.get(locale).format(new Date(timestamp.getTime()));
    }

    /**
     * Format the datetime
     *
     * @param date input time
     * @return formatted date time
     */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return null;
        }

        return formatDateTime(Locale.getDefault(), date);
    }

    /**
     * Format the datetime
     *
     * @param locale selected locale
     * @param date   input time
     * @return formatted date time
     */
    public static String formatDateTime(Locale locale, Date date) {
        if (date == null) {
            return null;
        }

        if (locale == null) {
            locale = Locale.getDefault();
        }

        return localeToFormatter.get(locale).format(date);
    }
}
