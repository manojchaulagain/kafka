package com.tutorial;

import java.util.Arrays;

public class MagneticForces {

    public static void main(String[] args) {
        System.out.println(new MagneticForces().maxDistance(new int[]{
                15,17,20
        }, 2));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        return search(position, 1, position[position.length - 1], m);

    }

    public int search(int[] position, int l, int r, int f) {
        int ans = 0;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isValid(m, position, f)) {
                l = m + 1;
                ans = m;
            } else {
                r = m - 1;
            }
        }
        return ans;
    }

    public boolean isValid(int target, int[] position, int f) {
        int c = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if ((position[i] - c) >= target) {
                count++;
                c = position[i];
            }
            if(count == f) return true;
        }
        return false;
    }
}
