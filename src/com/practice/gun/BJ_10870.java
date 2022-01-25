package com.practice.gun;

import java.util.Scanner;

public class BJ_10870 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n + 1];

        int answer = Fibo(n);
        System.out.println(answer);
    }

    private static int Fibo(int n) {

        if (arr[n] != 0) return arr[n];

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else return arr[n] = Fibo(n - 1) + Fibo(n - 2);

    }
}
