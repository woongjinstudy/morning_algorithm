package com.practice.yeseul;

import java.util.Scanner;

public class BJ_2156 {
    static int n, wine[], dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        wine = new int[n+1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        dp[0] = 0;
        dp[1] = wine[1];
        if (n > 1) {
            dp[2] = dp[1] + wine[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        return dp[n];
    }
}
