package com.practice.gun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178 {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        bfs();

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void bfs() {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {

            int[] tmp = q.poll();
            int x = tmp[0];
            int y = tmp[1];
            int step = tmp[2];

            if (x == n - 1 && y == m - 1) {
                answer = step;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && 0 <= ny && nx < n && ny < m && map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    q.add(new int[]{nx, ny, step + 1});
                }
            }

        }

    }

}
