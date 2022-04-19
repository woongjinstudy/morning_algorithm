package com.practice.yeseul;

import java.util.Scanner;

public class BJ_4963 {
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, -1, 1, 1, -1};
    static int w, h;
    static int arr[][];
    static boolean visit[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;

            arr = new int[h][w];
            visit = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int islandCnt = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (arr[i][j] == 1 && !visit[i][j]) {
                        islandCnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(islandCnt);
        }
    }

    private static void dfs(int i, int j) {
        visit[i][j] = true;
        for (int m = 0; m < 8; m++) {
            int tmpX = i + dx[m];
            int tmpY = j + dy[m];
            if (tmpX >= 0 && tmpY >= 0 && tmpX < h && tmpY < w) {
                if (arr[tmpX][tmpY] == 1 && !visit[tmpX][tmpY]) {
                    dfs(tmpX, tmpY);
                }
            }
        }
    }
}
