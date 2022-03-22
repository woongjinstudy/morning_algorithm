package com.practice.jinsoo;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2066 {
    static String[][] cards = new String[9][4];
    static int total = 36;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 4; j++) {
                cards[i][j] = sc.next();
            }
        }
        System.out.println(Arrays.deepToString(cards));
    }

    public static void game() {

    }
}
