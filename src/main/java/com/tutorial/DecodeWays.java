package com.tutorial;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(decodeWays("12", 0));
    }

    public static int decodeWays(String value, int index) {
        if (value.length() == index) {
            return 1;
        }
        if (value.length() == 1) {
            return value.charAt(index) == '0' ? 0 : 1;
        }
        return 0;
    }
}
