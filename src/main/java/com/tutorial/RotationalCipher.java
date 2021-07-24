package com.tutorial;

public class RotationalCipher {

    public static void main(String[] args) {
        rotate('0', 5);
    }

    private static void rotate(char c, int places) {
        if(Character.isDigit(c)) {
            char t =  (char) ((int) '0' + ((int) c + places - (int) '0') % 10);
            System.out.println(t);
        }

        System.out.println(Math.pow(1.1, 79) + Math.pow(1.2, 79) + Math.pow(1.3, 79));
    }
}


