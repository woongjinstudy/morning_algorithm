package com.practice.gun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2693 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] arr = new int[n][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
            System.out.println(arr[i][7]);
        }

    }

}
