package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_14501 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Work[] arr = new Work[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            arr[i] = new Work(t, p);
        }

        int dp[] = new int[n + 1];

        for (int i = 0; i < n; i++) {
            if (i + arr[i].t <= n) {
                dp[i + arr[i].t] = Math.max(dp[i + arr[i].t], dp[i] + arr[i].p);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        for (int i = 0; i <= n; i++) {
            System.out.println(dp[i]);
        }
        bw.write(dp[n] + "");

        bw.flush();
        bw.close();
        br.close();

    }

}

class Work {
    int t;
    int p;

    public Work(int t, int p) {
        this.t = t;
        this.p = p;
    }
}
