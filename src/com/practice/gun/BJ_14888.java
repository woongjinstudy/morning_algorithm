package com.practice.gun;

import java.util.Scanner;

public class BJ_14888 {

    static int[] numbers;
    static int[] operators = new int[4];
    static int n;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        DFS(numbers[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    private static void DFS(int number, int L) {

        if (L == n) {
            max = Math.max(number, max);
            min = Math.min(number, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0:
                        DFS(number + numbers[L], L + 1);
                        break;
                    case 1:
                        DFS(number - numbers[L], L + 1);
                        break;
                    case 2:
                        DFS(number * numbers[L], L + 1);
                        break;
                    case 3:
                        DFS(number / numbers[L], L + 1);
                        break;
                }
                operators[i]++;
            }
        }

    }

}
