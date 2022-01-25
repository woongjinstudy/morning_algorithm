package com.practice.gun;

import java.util.Scanner;

public class BJ_3460 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        String answer = "";

        for (int i : arr) {
            int cycle = 0;
            while (i / 2 > 0) {
                int rest = i % 2;
                if (rest == 1) answer += cycle + " ";
                i /= 2;
                cycle++;
            }
            if (i == 1) answer += cycle + " ";
        }

        System.out.println(answer);

    }

}
