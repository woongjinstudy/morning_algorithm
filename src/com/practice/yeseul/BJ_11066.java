package com.practice.yeseul;

import java.util.Scanner;

public class BJ_11066 {
    static int dp[][] = new int[501][501];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            System.out.println(getAnswer());
        }
    }

    private static int getAnswer() {
        int n = sc.nextInt();
        int cost[] = new int[n + 1];
        int sum[] = new int[n + 1];
        for (int j = 1; j <= n; j++) {
            cost[j] = sc.nextInt();
            sum[j] = sum[j - 1] + cost[j];
        }

        for (int k = 1; k < n; k++) {
            for (int tx = 1; tx + k <= n; tx++) {
                int ty = tx + k;
                dp[tx][ty] = Integer.MAX_VALUE;

                for (int mid = tx; mid < ty; mid++) {
                    dp[tx][ty] = Math.min(dp[tx][ty], dp[tx][mid] + dp[mid + 1][ty] + sum[ty] - sum[tx - 1]);
                }
            }
        }
        return dp[1][n];
    }
}
