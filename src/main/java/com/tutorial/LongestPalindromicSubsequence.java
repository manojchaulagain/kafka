package com.tutorial;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbab"));
    }

    public static int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        // Length 1
        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // Length 2
        for(int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = s.charAt(i) == s.charAt(i + 1) ? 2: 1;
        }
        for(int i = s.length() - 1; i >= 0; i--) {
            for(int j = i + 1; j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i+1][j]);
                }
            }
        }

        return dp[0][s.length() -1];

    }
}
