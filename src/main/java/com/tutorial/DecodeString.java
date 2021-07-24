package com.tutorial;

public class DecodeString {

    public static void main(String[] args) {
        new DecodeString().decode("mnes__ya_____mi", 3);
    }

    public String decode(String s, int n) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        for (int i = 0; i < n; i++) {
            int r = 0;
            while(r < n) {
                int a = r * (l) / n + r + i;
                if(s.charAt(a) == '_') {
                    sb.append(" ");
                }else {
                    sb.append(s.charAt(a));
                }
                r++;
            }

        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
