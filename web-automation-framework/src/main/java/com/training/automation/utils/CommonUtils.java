package com.training.automation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class contains common utility methods facilitating mobile
 * automation scripts.
 *
 * @author arun.pareek
 */
public class CommonUtils {

    /**
     * This method is used to get time stamp
     *
     * @param pattern for example: dd-MMM-yyyy hh-mm-ss
     * @return Current system date with time stamp
     *
     * @author Sandib.Nayak
     */
    public static String getCurrentTime(String pattern) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        String format = dateFormat.format(date);
        return format;
    }

    /**
     * This method returns the substring of input string matched with regex
     *
     * @param text  A text
     * @param regex A regular expression to be compiled with the input Text
     * @return A Returns the whole matched (@String) expression against the input Text
     *
     * @author Sandib.Nayak
     */
    public static String getSubstringWithRegEx(String text, String regex) {
        String matchedText = null;
        try {
            if (regex.trim().equals("") || regex == null) {
                System.out.println("The regular expression can't be null or blank");
            } else if (text.trim().equals("") || text == null) {
                System.out.println("The input Text can't be null or blank");
            } else {
                Pattern p = Pattern.compile(regex);
                Matcher m = p.matcher(text);
                if (m.find()) {
                    matchedText = m.group(0);
                } else {
                    System.out.println("No matches found with regex '" + regex + "' for given text '" + text + "'");
                }
            }
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return matchedText;
    }
}
