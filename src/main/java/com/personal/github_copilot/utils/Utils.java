package com.personal.github_copilot.utils;

import java.util.Date;

public class Utils {
    public static class DateUtil {
        public static String getCurrentDate() {
            return new java.text.SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
        }

        public static String getCurrentTime() {
            return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date());
        }

        public static String getCurrentDateTime() {
            return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
        }

        public static boolean isBadDate(String date) {
            return date == null || date.isEmpty();
        }

        public static boolean isGivenDateBeforeCurrentDate(String date) {
            if (isBadDate(date)) {
                return false;
            }
            return date.compareTo(getCurrentDate()) < 0;
        }

        public static boolean isGivenDateAfterCurrentDate(String date) {
            if (isBadDate(date)) {
                return false;
            }
            return date.compareTo(getCurrentDate()) > 0;
        }

        public static String convertDateToSqlDate(String date) {
            if (isBadDate(date)) {
                return date;
            }
            return date + " 00:00:00";
        }

        public static String convertDateFromOneFormatToOther(String date, String fromFormat, String toFormat) {
            if (isBadDate(date)) {
                return date;
            }
            try {
                java.util.Date dateObj = new java.text.SimpleDateFormat(fromFormat).parse(date);
                return new java.text.SimpleDateFormat(toFormat).format(dateObj);
            } catch (Exception e) {
                return date;
            }
        }

        public static String convertDateToOneFormatFromOtherWithException(String date, String fromFormat, String toFormat) throws Exception {
            if (isBadDate(date)) {
                throw new Exception("Date is null or empty");
            }
            try {
                Date dateObj = new java.text.SimpleDateFormat(fromFormat).parse(date);
                return new java.text.SimpleDateFormat(toFormat).format(dateObj);
            } catch (Exception e) {
                throw new Exception("Date format is not correct");
            }
        }
    }

    public static class StringUtil {
        public static boolean isValidEmail(String email) {
            if (isBadString(email)) {
                return false;
            }
            return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
        }
        public static boolean isBadString(String str) {
            return str == null || str.isEmpty();
        }

        public static String reverse(String str) {
            if (isBadString(str)) {
                return str;
            }
            return new StringBuilder(str).reverse().toString();
        }

        public static String capitalize(String str) {
            if (isBadString(str)) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }

        public static String uncapitalize(String str) {
            if (isBadString(str)) {
                return str;
            }
            return str.substring(0, 1).toLowerCase() + str.substring(1);
        }

        public static String toCamelCase(String str) {
            if (isBadString(str)) {
                return str;
            }
            String[] words = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(capitalize(word));
            }
            return sb.toString();
        }

        public static String toSnakeCase(String str) {
            if (isBadString(str)) {
                return str;
            }
            String[] words = str.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(uncapitalize(word)).append("_");
            }
            return sb.substring(0, sb.length() - 1);
        }

        public static String returnNonNullStringFromMultiple(String... strs) {
            for (String str : strs) {
                if (!isBadString(str)) {
                    return str;
                }
            }
            return "";
        }
    }
}
