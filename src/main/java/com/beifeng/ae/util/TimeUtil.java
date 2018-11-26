package com.beifeng.ae.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeUtil {
    public static final String dateFormat = "yyyy-MM-dd";

    /**
     * 获得指定时间字符串的[年，季度，月，周，天]的数组对象。时间字符格式要求为yyyy-MM-dd
     * 
     * @param str
     *            比如: 2015-04-01
     * @return
     */
    public static int[] getDateInfo(String str) {
        Date date = parseString2Date(str, dateFormat);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int season = (month % 3 == 0 ? month / 3 : month / 3 + 1);
        int week = cal.get(Calendar.WEEK_OF_YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int[] arr = { year, season, month, week, day };
        return arr;
    }

    /**
     * 将规定格式的时间字符串转化为时间对象
     * 
     * @param date
     *            时间字符串，比如2014-05-01
     * @param format
     *            时间格式字符串，比如yyyy-MM-dd
     * @return
     */
    public static Date parseString2Date(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(date);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 将时间对象转化为指定格式的字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String parseDate2String(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    /**
     * 获取指定时间所述周的第一天
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayOfThisWeek(String date, String format) {
        Date d = parseString2Date(date, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return parseDate2String(cal.getTime(), format);
    }

    /**
     * 获取指定时间所属周的最后一天对应格式的时间字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getLastDayOfThisWeek(String date, String format) {
        Date d = parseString2Date(date, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.WEEK_OF_YEAR, 0);
        cal.set(Calendar.DAY_OF_WEEK, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return parseDate2String(cal.getTime(), format);
    }

    /**
     * 获取指定时间当前月的第一天对应格式的时间字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getFirstDayOfThisMonth(String date, String format) {
        Date d = parseString2Date(date, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return parseDate2String(cal.getTime(), format);
    }

    /**
     * 获取当前月的最后一天对应格式的时间字符串
     * 
     * @param date
     * @param format
     * @return
     */
    public static String getLastDayOfThisMonth(String date, String format) {
        Date d = parseString2Date(date, format);
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONDAY, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return parseDate2String(cal.getTime(), format);
    }

    /**
     * 检查指定的时间字符串是否是有效时间格式的字符串，有效时间格式的字符串要求为2015-01-02类似的字符串。
     * 
     * @param date
     * @return
     */
    public static boolean checkDate(String date) {
        String regex = "^\\d{4}-\\d{1,2}-\\d{1,2}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(date);
        return matcher.matches();
    }

    /**
     * @param amount
     *            : amount day before or after.
     * @param today
     *            : long date like 2015-06-18
     * @return : string date like 2015-06-18<br />
     *         example : getSpecifiedDate (today, 2) : get the date of the day
     *         after tomorrow<br />
     *         getSpecifiedDate (today, -1) : get the date of yesterday
     */
    public static String getSpecifiedDate(String today, int amount) {
        return TimeUtil.getSpecifiedDate(today, amount, TimeUtil.dateFormat);
    }

    /**
     * @param amount
     *            : amount day before or after.
     * @param today
     *            : long date like 2015-08-15
     * @param pattern
     *            : the return the date format pattern
     * @return : string date like 2015-06-18 10:12:25 <br />
     *         example : getSpecifiedDate (today, 2, "yyyy-MM-dd HH:mm:ss") :
     *         get the date of the day after tomorrow<br />
     *         getSpecifiedDate (today, -1, "yyyy-MM-dd HH:mm:ss") : get the
     *         date of yesterday
     */
    public static String getSpecifiedDate(String today, int amount, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = parseString2Date(today, pattern);
        Calendar calStart = Calendar.getInstance();
        calStart.setTime(d);
        calStart.add(Calendar.DAY_OF_YEAR, amount);
        return sdf.format(calStart.getTime());
    }
}
