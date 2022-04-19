package com.practice.yeseul;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2178 {
    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }

    static int n, m;
    static int map[][];
    static boolean visit[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int dx[] = {-1, 1, 0, 0};
        int dy[] = {0, 0, -1, 1};
        int minCnt = Integer.MAX_VALUE;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 1));
        visit[0][0] = true;

        while (!queue.isEmpty()) {
            Point p = queue.remove();
            int queueX = p.x;
            int queueY = p.y;
            int cnt = p.cnt;
            if (queueX == n - 1 && queueY == m - 1) {
                minCnt = Math.min(minCnt, cnt);
            }

            for (int i = 0; i < 4; i++) {
                int tmpX = queueX + dx[i];
                int tmpY = queueY + dy[i];
                if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < m) {
                    if (map[tmpX][tmpY] == 1 && !visit[tmpX][tmpY]) {
                        queue.add(new Point(tmpX, tmpY, cnt + 1));
                        visit[tmpX][tmpY] = true;
                    }
                }
            }
        }
        return minCnt;
    }
}
