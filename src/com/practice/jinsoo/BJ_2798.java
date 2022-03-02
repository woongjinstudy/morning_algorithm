package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }

        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int tmp = cards[i] + cards[j] + cards[k];
                    if (tmp == m){
                        System.out.println(m);
                        return;
                    }
                    else if (res < tmp && tmp <= m) {
                        res = tmp;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
