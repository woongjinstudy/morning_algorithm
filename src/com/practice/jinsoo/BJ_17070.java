package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_17070 {
    static int res = 0;
    static int[][] map;
    static int[][] dir = {
            {0,1}, {1,1}, {1,0}
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        Move(0, 1, 0);
        System.out.println(res);
    }

    public static void Move(int x, int y, int c) {
        int n = map.length;
        if (x == n-1 && y == n-1) {
            res++;
            return;
        }

        int nx = 0;
        int ny = 0;

        if (c == 0) {
            for (int i = 0; i < 2; i++) {
                nx = x + dir[i][0];
                ny = y + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        if (i == 1) {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
                                Move(nx, ny, i);
                            } else continue;
                        } else Move(nx, ny, i);
                    } else continue; // 벽 만님
                } else continue;  // 맵 밖으로 나가는 경우
            }
        } else if (c == 1) {
            for (int i = 0; i < 3; i++) {
                nx = x + dir[i][0];
                ny = y + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        if (i == 1) {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
                                Move(nx, ny, i);
                            } else continue;
                        } else Move(nx, ny, i);
                    } else continue; // 벽 만님
                } else continue;  // 맵 밖으로 나가는 경우
            }
        } else {
            for (int i = 1; i < 3; i++) {
                nx = x + dir[i][0];
                ny = y + dir[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    if (map[nx][ny] == 0) {
                        if (i == 1) {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
                                Move(nx, ny, i);
                            } else continue;
                        } else Move(nx, ny, i);
                    } else continue; // 벽 만님
                } else continue;  // 맵 밖으로 나가는 경우
            }
        }
        return;
    }

}
