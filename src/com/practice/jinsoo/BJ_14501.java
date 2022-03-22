package com.practice.jinsoo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_14501 {
    static int n;
    static int[] t = new int[15];
    static int[] p = new int[15];
    static int[] dp = new int[16];
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0; i--) {
//            System.out.println(Arrays.toString(dp));
            int time = t[i] + i;
            if (time <= n) {
                dp[i] = Math.max(p[i] + dp[time], res);
                res = dp[i];
            }
            else dp[i] = res;
        }

        System.out.println(res);
    }
}
