package com.practice.WJStudy;

import java.util.Scanner;

public class BJ_3460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            String binary = Integer.toBinaryString(x);
            int res = 0;
            for (int j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '1') {
                    System.out.print(res + " ");
                }
                res++;
            }
            System.out.println();
        }
    }
}
