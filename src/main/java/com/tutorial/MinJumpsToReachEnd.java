package com.tutorial;

import java.util.Arrays;

public class MinJumpsToReachEnd {

    public static void main(String[] args) {
        new MinJumpsToReachEnd().minJumps(new int[] {
                2, 3, 1, 1, 2, 4, 2, 0 , 1, 1
        });
    }

    public int minJumps(int[] arr) {
        int[] jumps = new int[arr.length];
        Arrays.fill(jumps, arr.length + 1);
        jumps[0] = 0;
        int[] is = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < i; j++) {
                if((i - j) <= arr[j]) {
                    if(jumps[i] > 1 + jumps[j])
                        is[i] = j;
                    jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
                }
            }
        }
        return jumps[arr.length - 1];
    }
}
