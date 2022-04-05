package com.practice.gun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BJ_2156 {
    static int[] wine;
    static int n;
    static int[] dp = new int[10001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        wine = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            wine[i] = Integer.parseInt(st.nextToken());
        }

        solution();

        bw.write(dp[n] + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static void solution() {

        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                dp[i] = wine[1];
                continue;
            }

            if (i == 2) {
                dp[2] = wine[1] + wine[2];
                continue;
            }

            //oox
            int first = dp[i - 1];
            //oxo
            int second = dp[i - 2] + wine[i];
            //xoo
            int third = dp[i - 3] + wine[i - 1] + wine[i];

            dp[i] = Math.max(first, Math.max(second, third));
        }

    }
}
