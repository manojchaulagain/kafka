package com.tutorial;

public class isPalindrome {

    public static void main(String[] args) {
     new isPalindrome().isPalindrome(121);
    }

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        int target = 0;
        int num = x;
        while(num > 0) {
            target = target * 10 + (num % 10);
            num /= 10;
        }
        return target == x;
    }


}
