package com.practice.yeseul;

import java.util.Scanner;

public class BJ_1149 {
    static int n, dp[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = sc.nextInt();
            }
        }
        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) dp[i][j] = dp[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                if (j == 1) dp[i][j] = dp[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                if (j == 2) dp[i][j] = dp[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}
