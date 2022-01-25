package com.practice.gun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2309 {

    static int[] arr = new int[9];
    static int[] answer = new int[7];
    static int[] ch = new int[7];
    static boolean test = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        combi(0, 0);

    }

    private static void combi(int L, int s) {
        if (test) return;

        if (L == 7) {
            int sum = 0;
            for (int i : answer) {
                sum += i;
            }

            if (sum == 100) {
                for (int i : answer) {
                    System.out.println(i);
                }
                test = true;
            }

        } else {
            for (int i = s; i < 9; i++) {
                answer[L] = arr[i];
                combi(L + 1, i + 1);
            }
        }

    }

}

