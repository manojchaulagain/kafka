package com.tutorial;

import scala.math.ScalaNumber;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(new MajorityElement().findMajorityElement(new int[] {
                1, 1, 1, 2, 2
        }));
    }

    public boolean isMajority(int[] arr, int index) {
        int count = 0;
        for (int j : arr) {
            if (j == arr[index]) {
                count++;
            }
        }
        return arr.length / 2 < count;
    }

    public int findMajorityElement(int[] arr) {
        int cadidate_index = 0;
        int count = 1;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[cadidate_index]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                cadidate_index = i;
                count = 1;
            }
        }
        return isMajority(arr, cadidate_index) ? arr[cadidate_index]: -1;
    }
}
