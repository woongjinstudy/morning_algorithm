package com.practice.yeseul;

import java.util.Scanner;

import static java.lang.System.exit;

public class BJ_2798 {
    static int n, m;
    static int[] cards;
    static boolean[] visit;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cards = new int[n];
        visit = new boolean[n];
        for (int i = 0; i < n; i++) {
            cards[i] = sc.nextInt();
        }
        getAnswer(0, 0, 0);
        System.out.println(m - minDiff);
    }

    private static void getAnswer(int idx, int sum, int cnt) {
        if (cnt == 3) {
            int diff = m - sum;
            if (diff >= 0) {
                if (diff == 0) {
                    System.out.println(m);
                    exit(0);
                }
                minDiff = Math.min(minDiff, m - sum);
            }
            return;
        } else {
            for (int i = idx; i < n; i++) {
                if (!visit[i]) {
                    visit[i] = true;
                    getAnswer(idx + 1, sum + cards[i], cnt + 1);
                    visit[i] = false;
                }
            }
        }
    }
}
