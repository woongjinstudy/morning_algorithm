package com.practice.yeseul;

import java.util.Scanner;

public class BJ_14501 {
    static int t[], p[], dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        t = new int[n + 1];
        p = new int[n + 1];
        dp = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }
        System.out.println(getAnswer(n));
    }

    private static int getAnswer(int n) {
        for (int i = n; i >= 1; i--) {
            if (i + t[i] <= n + 1) {
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[1];
    }
}
