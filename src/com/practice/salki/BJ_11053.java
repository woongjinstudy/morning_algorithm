package com.practice.salki;

import java.util.Scanner;

public class BJ_11053 {

    public static int n;
    public static int result;
    public static int[] a = new int[1001];
    public static int[] dp = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
//        a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[j] < a[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            result = Math.max(result, dp[i]);
        }
        System.out.println(result);
    }
}

