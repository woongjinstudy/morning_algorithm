package com.practice.yeseul;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2110 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] house = new int[n];
        for (int i = 0; i < n; i++) {
            house[i] = sc.nextInt();
        }
        Arrays.sort(house);
        System.out.println(findMaxDist(n, c, house));
    }

    private static int findMaxDist(int n, int c, int[] house) {
        int start = 1;
        int end = house[n - 1] - house[0];
        int maxDist = Integer.MIN_VALUE;

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 1;
            int nowLocat = house[0];
            for (int i = 1; i < n; i++) {
                if (house[i] - nowLocat >= mid) {
                    cnt++;
                    nowLocat = house[i];
                }
            }
            if (cnt < c) {
                end = mid - 1;
            } else {
                maxDist = Math.max(maxDist, mid);
                start = mid + 1;
            }
        }
        return maxDist;
    }
}
