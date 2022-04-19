package com.practice.yeseul;

import java.util.Scanner;

public class BJ_3360 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(getAnswer(n));
    }

    private static long getAnswer(long n) {
        long cnt = 0;
        for (long a = 0; a <= n / 3; a++) {
            cnt += (n - 3 * a) / 2 + 1;
            cnt %= 1000000000;
        }
        return cnt;
    }
}
