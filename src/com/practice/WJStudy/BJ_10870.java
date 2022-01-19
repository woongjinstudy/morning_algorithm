package com.practice.WJStudy;

import java.util.Scanner;

public class BJ_10870 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int first = 0;
        int second = 1;

        int sum = 0;
        for (int i = 1; i < n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        if (n == 1) {
            System.out.println(1);
        }
        else System.out.println(sum);
    }
}
