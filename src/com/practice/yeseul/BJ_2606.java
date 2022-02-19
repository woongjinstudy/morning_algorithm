package com.practice.yeseul;

import java.util.Scanner;

public class BJ_2606 {
    static int cnt = 0;
    static boolean map[][];
    static boolean visit[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        map = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            int com1 = sc.nextInt();
            int com2 = sc.nextInt();
            map[com1][com2] = map[com2][com1] = true;
        }
        dfs(1, n);
        System.out.println(cnt);
    }

    private static void dfs(int com1, int n) {
        visit[com1] = true;
        for (int com2 = 1; com2 <= n; com2++) {
            if (!visit[com2] && map[com1][com2]) {
                cnt++;
                dfs(com2, n);
            }
        }
    }
}
