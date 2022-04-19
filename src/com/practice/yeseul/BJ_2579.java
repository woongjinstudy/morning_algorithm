package com.practice.yeseul;

import java.util.Scanner;

public class BJ_2579 {
    static int n;
    static int arr[] = new int[301];
    static int dp[] = new int[301];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2];
        dp[3] = Math.max(arr[1], arr[2]) + arr[3];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
        }
        return dp[n];
    }
}
