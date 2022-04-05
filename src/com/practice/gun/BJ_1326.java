package com.practice.gun;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1326 {
    static int n, a, b;
    static int[] dp = new int[100001];
    static int[] bridge;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        bridge = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int answer = solution();

        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int solution() {

        int cnt = -1;

        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        dp[a] = 1;

        while (!q.isEmpty()) {

            int cur = q.poll();
//            if (cur == b) break;
            int jump = bridge[cur];

            int rt = cur + jump;
            int lt = cur - jump;

            while (rt <= b) {
                if (dp[rt] == 0 || dp[rt] > dp[cur] + 1) {
                    dp[rt] = dp[cur] + 1;
                    q.add(rt);
                }
                rt += jump;

            }

            while (lt >= 1) {
                if (dp[lt] == 0 || dp[lt] > dp[cur] + 1) {
                    dp[lt] = dp[cur] + 1;
                    q.add(lt);
                }
                lt -= jump;

            }

        }

        if (dp[b] != 0) cnt = dp[b] - 1;

        return cnt;

    }
}
