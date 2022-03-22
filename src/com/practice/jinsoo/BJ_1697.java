package com.practice.jinsoo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
    static int[] visit = new int[100001];
    static int k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        k = sc.nextInt();

        if (n == k) {
            System.out.println(0);
            return;
        } else {
            find(n);
        }
    }

    public static void find(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = 1;

        while (!q.isEmpty()) {
            int temp = q.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = temp + 1;
                } else if (i == 1) {
                    next = temp - 1;
                } else {
                    next = temp * 2;
                }

                if (next == k) {
                    System.out.println(visit[temp]);
                    return;
                }

                if (next >= 0 && next < visit.length && visit[next] == 0) {
                    q.add(next);
                    visit[next] = visit[temp] + 1;
                }
            }
        }
    }
}
