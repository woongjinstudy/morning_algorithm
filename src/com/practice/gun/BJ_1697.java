package com.practice.gun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1697 {

    static int n, k;
    static int[] ch = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) System.out.println(0);
        else
            bfs();

        br.close();

    }

    private static void bfs() {

        Queue<Integer> q = new LinkedList<>();

        q.add(n);
        ch[n] = 1;

        int cnt = 0;

        while (!q.isEmpty()) {

            int tmp = q.poll();

            for (int i = 0; i < 3; i++) {

                int next;

                if (i == 0) {
                    next = tmp - 1;
                } else if (i == 1) {
                    next = tmp + 1;
                } else {
                    next = tmp * 2;
                }

                if (next == k) {
                    System.out.println(ch[tmp]);
                    return;
                }

                if (0 <= next && next <= 100000 && ch[next] == 0) {
                    q.add(next);
                    ch[next] = ch[tmp] + 1;
                }

            }

        }

    }

}
