package com.tutorial;

public class CountAndSay {

    public static void main(String[] args) {
        String val = "2";
        for(int i = 0; i < 10; i++) {
            System.out.println(val);
            val = new CountAndSay().countString(val);
        }
    }

    private String countString(String val) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        if (val.length() == 1) {
            sb.append(count).append(val.charAt(0));
            return sb.toString();
        }
        for (int i = 1; i < val.length(); i++) {
            if (val.charAt(i) == val.charAt(i - 1)) count++;
            else {
                sb.append(count).append(val.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count).append(val.charAt(val.length() - 1));
        return sb.toString();
    }
}
