package com.tutorial;

public class FindNonDuplicateInArray {

    public static void main(String[] args) {
        new FindNonDuplicateInArray().findNonDup(new int[]{1, 1, 3, 5, 5});
    }

    public void findNonDup(int[] arr) {
        int a = 0;
        for (int i : arr) {
            a ^= i;
        }
        System.out.println(a);
    }
}
