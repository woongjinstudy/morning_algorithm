package com.practice.WJStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1292 {
    public static void main(String[] args) {

        ArrayList<Integer> easy_solve = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        Scanner sc = new Scanner(System.in);
        int left = sc.nextInt();
        int right = sc.nextInt();

        int cnt = 1;
        int sum = 0;

        for (int i = 1; i <= 1000; i++) {
            for (int j = 1; j <= i; j++) {
                if (cnt <= 1000) {
                    easy_solve.add(i);
                    cnt ++;
                    sum += i;
                    result.add(sum);
                } else break;
            }
        }
        System.out.println(result.get(right) - result.get(left-1));
    }
}
