package com.practice.yeseul;

import java.util.Scanner;

public class BJ_1495 {
    static int n, s, m, volumn[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        s = sc.nextInt();
        m = sc.nextInt();
        volumn = new int[n];
        for (int i = 0; i < n; i++) volumn[i] = sc.nextInt();
        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int dp[][] = new int[n][m + 1];
        if (s + volumn[0] <= m) dp[0][s + volumn[0]] = 1;
        if (s - volumn[0] >= 0) dp[0][s - volumn[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                if (dp[i - 1][j] == 1) {
                    if (j + volumn[i] <= m) dp[i][j + volumn[i]] = 1;
                    if (j - volumn[i] >= 0) dp[i][j - volumn[i]] = 1;
                }
            }
        }
        for (int i = m; i >= 0; i--) {
            if (dp[n - 1][i] == 1) return i;
        }
        return -1;
    }

}
