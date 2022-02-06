package com.practice.gun;

import java.util.Scanner;

public class BJ_1806 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MAX_VALUE;
        int sum = 0;

        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum >= s) {
                answer = Math.min(answer, rt - lt + 1);
            }
            while (sum >= s) {
                sum -= arr[lt];
                lt++;
                if (sum >= s) {
                    answer = Math.min(answer, rt - lt + 1);
                }
            }
        }

        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);

    }

}
