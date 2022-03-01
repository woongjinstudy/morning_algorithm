package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_17070 {

    static int n;
    static int[][] map;
    static int answer;
    static int[] dx1 = {0, 1};
    static int[] dy1 = {1, 1};
    static int[] dx2 = {1, 1};
    static int[] dy2 = {0, 1};
    static int[] dx3 = {0, 1, 1};
    static int[] dy3 = {1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(0, 1, "h");

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int x, int y, String direction) {

        if (x == n - 1 && y == n - 1) {
            answer++;
            return;
        } else {

            if (direction.equals("h")) {//가로
                for (int i = 0; i < dx1.length; i++) {
                    int nx = x + dx1[i];
                    int ny = y + dy1[i];
                    if (nx < n && ny < n && map[nx][ny] == 0) {
                        if (i == 0) {
                            DFS(nx, ny, "h");
                        } else {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0)
                                DFS(nx, ny, "d");
                        }
                    }
                }
            } else if (direction.equals("v")) {//세로
                for (int i = 0; i < dx2.length; i++) {
                    int nx = x + dx2[i];
                    int ny = y + dy2[i];
                    if (nx < n && ny < n && map[nx][ny] == 0) {
                        if (i == 0) {
                            DFS(nx, ny, "v");
                        } else {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0)
                                DFS(nx, ny, "d");
                        }
                    }
                }
            } else {//대각선
                for (int i = 0; i < dx3.length; i++) {
                    int nx = x + dx3[i];
                    int ny = y + dy3[i];
                    if (nx < n && ny < n && map[nx][ny] == 0) {
                        if (i == 0) {
                            DFS(nx, ny, "h");
                        } else if (i == 1) {
                            DFS(nx, ny, "v");
                        } else {
                            if (map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0)
                                DFS(nx, ny, "d");
                        }
                    }
                }
            }

        }

    }
}
