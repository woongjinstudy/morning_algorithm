package com.practice.yeseul;

import java.util.Scanner;

public class BJ_1303 {
    static int n, m, dx[] = {-1, 1, 0, 0}, dy[] = {0, 0, -1, 1};
    static Character map[][];
    static boolean visit[][];
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        map = new Character[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int sumW = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    cnt = 1;
                    dfs(map[i][j], i, j);
                    if (map[i][j]=='W') {
                        sumW += cnt * cnt;
                    } else {
                        sumB += cnt * cnt;
                    }
                }
            }
        }
        System.out.println(sumW + " " + sumB);
    }

    private static void dfs(Character character, int row, int col) {
        visit[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int tmpRow = row + dx[i];
            int tmpCol = col + dy[i];
            if (checkRange(tmpRow, tmpCol) && map[tmpRow][tmpCol] == character && !visit[tmpRow][tmpCol]) {
                cnt++;
                dfs(map[tmpRow][tmpCol], tmpRow, tmpCol);
            }
        }

    }

    private static boolean checkRange(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m) return false;
        return true;
    }
}
