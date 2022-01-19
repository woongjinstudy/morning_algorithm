package com.practice.greedy;

import java.util.Scanner;

public class CardGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // n,m 공백을 기준으로 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();

        int res = 0;

        // 한 줄씩 입력받으면서 체크
        for (int i = 0; i < n; i++) {
            int min_value = 10001;
            for (int j = 0; j < m; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            res = Math.max(res, min_value);
        }
        System.out.println(res);
    }
}
