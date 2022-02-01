package com.practice.gun;

import java.util.Scanner;

public class BJ_1062 {

    static boolean ch[] = new boolean[26];
    static String words[];
    static int max = 0;
    static int n;
    static int k;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        words = new String[n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            str = str.substring(0, str.length() - 4);
            str = str.substring(4);
            words[i] = str;
        }

        ch[0] = true; //a
        ch[2] = true; //c
        ch[8] = true; //i
        ch[13] = true; //n
        ch[19] = true; //t

        if (k < 5) {
            System.out.println(0);
            return;
        } else if (k == 26) {
            System.out.println(n);
            return;
        }

        backtracking(0, 0);

        System.out.println(max);

    }

    private static void backtracking(int s, int L) {

        if (L == k - 5) {

            int cnt = 0;

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean flag = false;
                for (char c : word.toCharArray()) {
                    if (ch[c - 'a'] == false) {
                        flag = true;
                    }
                }
                if (!flag) cnt++;
            }

            max = Math.max(max, cnt);

        } else {

            for (int i = s; i < 26; i++) {
                if (ch[i] == false) {
                    ch[i] = true;
                    backtracking(i, L + 1);  /// DFS(s,L+1)로 해서 시간초과남
                    ch[i] = false;
                }
            }

        }

    }

}
