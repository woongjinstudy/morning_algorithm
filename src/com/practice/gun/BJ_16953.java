package com.practice.gun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16953 {

    static int a;
    static int b;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int answer = BFS();

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }

    private static int BFS() {

        Queue<Long> q = new LinkedList<>();
        q.add((long) a);

        int cnt = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                long tmp = q.poll();

                if (tmp == b) return cnt + 1;

                if (tmp * 2 <= b) q.add(tmp * 2);
                if (tmp * 10 + 1 <= b) q.add(tmp * 10 + 1);

            }

            cnt++;

        }

        return -1;

    }
}
