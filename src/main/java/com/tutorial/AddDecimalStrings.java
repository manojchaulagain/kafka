package com.tutorial;

import scala.Char;

public class AddDecimalStrings {

    public static void main(String[] args) {
        System.out.println(new AddDecimalStrings().add("212.540", "11.6120"));
        System.out.println(212.54 + 11.612);
        System.out.println(Character.getNumericValue('8'));
    }

    /**
     * 12.54 + 11.612 =
     *
     * @param a
     * @param b
     * @return
     */
    public String add(String a, String b) {
        int diff = (a.length() - 1 - a.indexOf('.')) - (b.length() - 1 - b.indexOf('.'));
        int diff2 = a.indexOf('.') - b.indexOf('.');
        if (diff > 0) {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < diff; i++) {
                bBuilder.append('0');
            }
            b = bBuilder.toString();
        } else {
            StringBuilder bBuilder = new StringBuilder(a);
            for (int i = 0; i < Math.abs(diff); i++) {
                bBuilder.append('0');
            }
            a = bBuilder.toString();
        }
        
        if (diff2 > 0) {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < diff2; i++) {
                bBuilder.insert(0, '0');
            }
            b = bBuilder.toString();
        } else {
            StringBuilder bBuilder = new StringBuilder(a);
            for (int i = 0; i < Math.abs(diff2); i++) {
                bBuilder.insert(0,'0');
            }
            a = bBuilder.toString();
        }

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        int length = Math.max(a.length(), b.length());
        for (int i = length - 1; i >= 0; i--) {
            if (a.charAt(i) == '.') {
                sb.append(".");
                continue;
            }


            int sum = Character.getNumericValue(a.charAt(i)) + Character.getNumericValue(b.charAt(i)) + carry;

            sb.append(sum % 10);
            carry = sum / 10;
        }


        return sb.reverse().toString();
    }
}
