package com.practice.WJStudy;

import java.util.Scanner;

public class BJ_2460 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int customer = 0;
        int max = 0;
        for (int i = 0; i < 10; i++) {
            int out = sc.nextInt();
            int in = sc.nextInt();
            customer -= out;
            customer += in;

            max = (max < customer) ? customer : max;

        }
        System.out.println(max);
    }
}
