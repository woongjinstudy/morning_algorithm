package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_2798 {

    static int n, m;
    static int[] ch = new int[3];
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];

        int index = 0;
        while (st.hasMoreTokens()) {

            arr[index] = Integer.parseInt(st.nextToken());
            index++;

        }

        DFS(0, 0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();

    }

    private static void DFS(int L, int s) {

        if (L == 3) {
            int sum = 0;
            for (int i : ch) {
                sum += i;
            }
            if (sum <= m) answer = Math.max(answer, sum);
        } else {
            for (int i = s; i < n; i++) {
                ch[L] = arr[i];
                DFS(L + 1, i + 1);
            }
        }
    }

}
