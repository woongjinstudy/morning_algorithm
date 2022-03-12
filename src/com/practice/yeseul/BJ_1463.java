package com.practice.yeseul;

import java.util.Scanner;

public class BJ_1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getAnswer(n));
    }

    private static int getAnswer(int n) {
        int dp[] = new int[1000001];
        for (int i = 4; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
            }
            dp[i] = Math.min(dp[i - 1] + 1, dp[i]);
        }
        return dp[n];
    }
}
