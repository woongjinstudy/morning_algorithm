package com.practice.yeseul;

import java.util.Scanner;

public class BJ_14889 {
    static int n;
    static int map[][];
    static boolean visit[];
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        visit[0] = true;
        pickTeam(1, 1);
        System.out.println(minDiff);
    }

    private static void pickTeam(int idx, int cnt) {
        if (cnt == n / 2) {
            minDiff = Math.min(minDiff, getDiff());
            return;
        }
        for (int i = idx; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                pickTeam(i + 1, cnt + 1);
                visit[i] = false;
            }
        }
    }

    private static int getDiff() {
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] && visit[j]) {
                    sum1 += map[i][j] + map[j][i];
                } else if (!visit[i] && !visit[j]) {
                    sum2 += map[i][j] + map[j][i];
                }
            }
        }
        if (Math.abs(sum1 - sum2) == 0) {
            System.out.println(0);
            System.exit(0);
        }
        return Math.abs(sum1 - sum2);
    }
}
