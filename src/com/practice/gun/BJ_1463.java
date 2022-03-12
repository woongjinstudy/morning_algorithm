package com.practice.gun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1463 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        int answer = BFS();
        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int BFS() {

        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        int cnt = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                int tmp = q.poll();

                if (tmp == 1) return cnt;

                if (tmp % 3 == 0) q.add(tmp / 3);
                if (tmp % 2 == 0) q.add(tmp / 2);
                q.add(tmp - 1);
            }

            cnt++;

        }

        return cnt;

    }

}
