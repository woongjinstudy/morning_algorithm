package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_4963 {

    static int w, h;
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int cnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        while (w != 0 && h != 0) {
            board = new int[h][w];
            cnt = 0;

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] != 0) {
                        board[i][j] = 0;
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            bw.write(cnt + "\n");

            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void dfs(int x, int y) {

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && 0 <= ny && nx < h && ny < w && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                dfs(nx, ny);
            }
        }

    }

}
