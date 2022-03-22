package com.practice.gun;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110 {

    static int[] arr;
    static int n, c;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int result = solution(arr);

        bw.write(result + "");

        bw.flush();
        bw.close();
        br.close();

    }

    private static int solution(int[] arr) {

        int answer = 0;

        int lt = 1;
        int rt = arr[n - 1];

        while (lt <= rt) {

            int distance = (lt + rt) / 2;
            if (count(distance) >= c) {
                answer = distance;
                lt = distance + 1;
            } else rt = distance - 1;

        }

        return answer;

    }

    private static int count(int distance) {

        int cnt = 1;
        int current = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] - current >= distance) {
                cnt++;
                current = arr[i];
            }
        }

        return cnt;

    }

}
