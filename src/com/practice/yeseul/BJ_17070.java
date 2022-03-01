package com.practice.yeseul;

import java.util.Scanner;

public class BJ_17070 {
    static int n, map[][];
    static int cnt = 0;
    static int[] dx = {0, 1, 1};
    static int[] dy = {1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0, 1, 0);
        System.out.println(cnt);
    }

    private static void dfs(int x, int y, int rc) {
        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }
        for (int i = 0; i < 3; i++) {
            if ((i == 0 && rc == 1) || (i == 1 && rc == 0)) continue;
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];

            if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < n && map[tmpX][tmpY] != 1) {
                if (i == 2 && (map[x+1][y] == 1 || map[x][y+1] == 1)) continue;
                dfs(tmpX, tmpY, i);
            }
        }
    }
}
