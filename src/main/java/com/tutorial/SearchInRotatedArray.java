package com.tutorial;

public class SearchInRotatedArray {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if(nums[m] == target) {
                return m;
            }
            if(nums[l] <= nums[m]) {
                if(target > nums[m] || target < nums[l]) {
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            } else {
                if(target < nums[m] || target > nums[r]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        new SearchInRotatedArray().search(new int[]{4,5,6,7,8,1,2, 3}, 8);
    }

}
