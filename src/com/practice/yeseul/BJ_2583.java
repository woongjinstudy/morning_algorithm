package com.practice.yeseul;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2583 {
    static int m, n, k;
    static boolean visit[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        k = sc.nextInt();

        visit = new boolean[n][m];
        for (int i = 0; i < k; i++) {
            int x1, y1, x2, y2;
            x1 = sc.nextInt();
            y1 = sc.nextInt();
            x2 = sc.nextInt();
            y2 = sc.nextInt();
            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    visit[x][y] = true;
                }
            }
        }

        ArrayList<Integer> arrList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visit[i][j]) {
                    cnt = 0;
                    getAnswer(i, j);
                    arrList.add(cnt);
                }
            }
        }
        Collections.sort(arrList);
        System.out.println(arrList.size());
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
    }

    private static void getAnswer(int x, int y) {
        visit[x][y] = true;
        cnt++;
        for (int i = 0; i < 4; i++) {
            int tmpX = x + dx[i];
            int tmpY = y + dy[i];
            if (tmpX >= 0 && tmpX < n && tmpY >= 0 && tmpY < m) {
                if (!visit[tmpX][tmpY]) {
                    getAnswer(tmpX, tmpY);
                }
            }
        }
    }
}
