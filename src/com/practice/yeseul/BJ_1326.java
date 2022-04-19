package com.practice.yeseul;

import java.util.Scanner;

public class BJ_1326 {
    static int n, arr[], a, b;
    static int minNum = Integer.MAX_VALUE;
    static boolean visit[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1];
        visit = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        a = sc.nextInt();
        b = sc.nextInt();

        getAnswer(a, 0);
        System.out.println(minNum == Integer.MAX_VALUE ? -1 : minNum);
    }

    private static void getAnswer(int now, int cnt) {
        if (now == b) {
            minNum = Math.min(minNum, cnt);
            return;
        } else if (now < b) {
            int jumpNum = arr[now];
            int num = 1;
            int jumpMultiple = 0;
            while (jumpMultiple <= n) {
                jumpMultiple = jumpNum * num;
                if (now + jumpMultiple <= n && !visit[now + jumpMultiple]) {
                    visit[now + jumpMultiple] = true;
                    getAnswer(now + jumpMultiple, cnt + 1);
                    visit[now + jumpMultiple] = false;
                }
                if (now - jumpMultiple >= 1 && !visit[now - jumpMultiple]) {
                    visit[now - jumpMultiple] = true;
                    getAnswer(now - jumpMultiple, cnt + 1);
                    visit[now - jumpMultiple] = false;
                }
                num++;
            }
        }
    }
}
