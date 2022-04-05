package com.practice.gun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_2531 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        int lt = 0;
        int rt = lt + k;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rt; i++) {
            map.put(sushi[i], map.getOrDefault(sushi[i], 0) + 1);
        }

        map.put(c, map.getOrDefault(c, 0) + 1);
        answer = map.size();
        map.put(c, map.get(c) - 1);

        for (int i = 1; i < n; i++) {
            map.put(sushi[i - 1], map.get(sushi[i - 1]) - 1);
            if (map.get(sushi[i - 1]) == 0) map.remove(sushi[i - 1]);
            int end = i + k - 1;
            if (end >= n) end -= n;
            map.put(sushi[end], map.getOrDefault(sushi[end], 0) + 1);
            map.put(c, map.getOrDefault(c, 0) + 1);
            answer = Math.max(answer, map.size());
            map.put(c, map.get(c) - 1);
        }

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}
