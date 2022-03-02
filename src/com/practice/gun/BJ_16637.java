package com.practice.gun;

import java.io.*;
import java.util.ArrayList;

public class BJ_16637 {

    static int answer = Integer.MIN_VALUE;
    static int n;
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (char c : br.readLine().toCharArray()) {
            if ('0' <= c && c <= '9') {
                nums.add(Character.getNumericValue(c));
            } else {
                ops.add(c);
            }
        }

        DFS(0, nums.get(0));

        if (answer == Integer.MIN_VALUE) answer = 0;

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static void DFS(int L, int current) {

        if (L == ops.size()) {
            answer = Math.max(answer, current);
        } else {

            DFS(L + 1, calculation(current, nums.get(L + 1), ops.get(L)));
            if (L + 2 <= ops.size())
                DFS(L + 2, calculation(current, calculation(nums.get(L + 1), nums.get(L + 2), ops.get(L + 1)), ops.get(L)));
        }

    }

    private static int calculation(int left, int right, Character c) {

        if (c == '-') {
            return left - right;
        } else if (c == '+') {
            return left + right;
        } else return left * right;
    }
}
