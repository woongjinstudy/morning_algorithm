package com.practice.gun;

import java.util.Scanner;

public class BJ_14719 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int arr[] = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = sc.nextInt();
        }

        int rain = 0;

        for (int i = 1; i < w - 1; i++) {

            int thisHeight = arr[i];
            int leftTop = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] >= thisHeight) leftTop = Math.max(leftTop, arr[j]);
            }
            int rightTop = 0;
            for (int j = i + 1; j < w; j++) {
                if (arr[j] >= thisHeight) rightTop = Math.max(rightTop, arr[j]);
            }

            int thisRain = Math.min(leftTop, rightTop);
            if (leftTop != 0 && rightTop != 0)
                rain += (thisRain - thisHeight);

        }

        System.out.println(rain);

    }

}
