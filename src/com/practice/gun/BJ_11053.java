package com.practice.gun;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_11053 {

    static int n;
    static int[] arr;
    static int[] ch;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new int[n];
        ch = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        ch[0] = 1;

        for (int i = 1; i < n; i++) {
            ch[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && ch[i] <= ch[j]) {
                    ch[i] = ch[j] + 1;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, ch[i]);
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
