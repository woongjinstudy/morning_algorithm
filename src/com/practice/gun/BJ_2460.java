package com.practice.gun;

import java.util.Scanner;

public class BJ_2460 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[20];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        int rest = 0;
        int max = 0;

        for (int i = 0; i < 10; i++) {
            int out = arr[2 * i];
            int in = arr[2 * i + 1];
            rest = rest - out + in;
            max = Math.max(rest, max);
        }

        System.out.println(max);

    }

}
