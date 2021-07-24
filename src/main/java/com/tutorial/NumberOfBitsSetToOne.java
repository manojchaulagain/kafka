package com.tutorial;

public class NumberOfBitsSetToOne {

    public static void main(String[] args) {
        int x = 3;
        int count = 0;
        while (x != 0) {
            count += x & 1;
            x >>>= 1;
        }
        System.out.println(count);

        int y = 4;
//        System.out.println((y >> 31));
//        System.out.println((y >>> 3));
        System.out.println(~ 2);
        System.out.println(y ^ 0);
        System.out.println(y ^ y);
//        System.out.println((y ^ 5));
        System.out.println(y & (y - 1));
        System.out.println(y & ~(y - 1));
    }
}
