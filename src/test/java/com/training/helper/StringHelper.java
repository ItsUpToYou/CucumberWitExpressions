package com.training.helper;

public class StringHelper {


    public StringHelper() {

    }

    public static boolean compareCaseSensitive(String a, String b) {
        return a.equals(b);
    }

    public static boolean compareCaseInsensitive(String a, String b) {
        return a.equalsIgnoreCase(b);
    }


    public static String removeChar(String str , String c) {
        String ex = str.replace(c, "");
        return ex;
    }
}
