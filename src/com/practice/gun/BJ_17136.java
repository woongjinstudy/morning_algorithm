package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_17136 {

    static int[][] board = new int[10][10];
    static int answer = Integer.MAX_VALUE;
    static int[] paper = {0, 5, 5, 5, 5, 5};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if (answer == Integer.MAX_VALUE) answer = -1;

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int idx, int cnt) {

        int x = idx / 10;
        int y = idx % 10;

        if (cnt > answer) return;

        if (idx == 100) {
            answer = Math.min(answer, cnt);
            return;
        } else {
            if (board[x][y] == 1) {
                for (int size = 5; size > 0; size--) {

                    if (check(x, y, size)) {
                        paper[size]--;
                        attach(x, y, size, 0);
                        dfs(idx + 1, cnt + 1);
                        attach(x, y, size, 1);
                        paper[size]++;
                    }

                }
            } else {
                dfs(idx + 1, cnt);
            }
        }

    }

    private static void attach(int x, int y, int size, int num) {

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = num;
            }
        }

    }

    private static boolean check(int x, int y, int size) {
        if (paper[size] < 1 || x + size > 10 || y + size > 10) return false;
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] == 0) return false;
            }
        }

        return true;

    }

}
