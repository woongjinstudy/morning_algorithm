package com.practice.gun;

import java.util.Scanner;

public class BJ_2581 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        boolean arr[] = new boolean[n + 1];
        arr[0] = true;
        arr[1] = true;
        //에라토스테네스의 체
        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) arr[j] = true;
        }

        int min = 0;
        int sum = 0;

        for (int i = m; i <= n; i++) {
            if (!arr[i]) {
                if (min == 0) min = i;
                sum += i;
            }
        }

        if (min == 0 && sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }

    }

}
