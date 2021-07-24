package com.tutorial;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestPrefix(new String[]{
                "geeksforgeeks", "geeks", "geek",
                "geezer"
        }));
        System.out.println(new LongestCommonPrefix().longestPrefix(new String[]{
                "hello", "world"
        }));
    }

    public String longestPrefix(String[] arr) {
        String prefix = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix = longestPrefix(prefix, arr[i]);
        }
        return prefix.isEmpty() ? "-1" : prefix;
    }

    public String longestPrefix(String a, String b) {
        int len = Math.min(a.length(), b.length());

        int i = 0;
        while (i < len && a.charAt(i) == b.charAt(i)) i++;
        return a.substring(0, i);

    }
}
