package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11053 {

    static int n;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int idx = 0;
        arr = new int[n];
        while (st.hasMoreTokens()) {
            arr[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
