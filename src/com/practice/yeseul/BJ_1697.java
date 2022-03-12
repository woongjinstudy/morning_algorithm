package com.practice.yeseul;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_1697 {
    static int N, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        find();
    }

    private static void find() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int minTime = Integer.MAX_VALUE;
        int visit[] = new int[100001];
        queue.add(N);
        visit[N] = 0;
        while (!queue.isEmpty()) {
            int queueNum = queue.remove();
            if (queueNum == K) {
                System.out.println(visit[queueNum]);
                return;
            }
            if (queueNum - 1 >= 0 && visit[queueNum - 1] == 0) {
                visit[queueNum - 1] = visit[queueNum] + 1;
                queue.add(queueNum - 1);
            }
            if (queueNum + 1 <= 100000 && visit[queueNum + 1] == 0) {
                visit[queueNum + 1] = visit[queueNum] + 1;
                queue.add(queueNum + 1);
            }
            if (queueNum * 2 <= 100000 && visit[queueNum * 2] == 0) {
                visit[queueNum * 2] = visit[queueNum] + 1;
                queue.add(queueNum * 2);
            }
        }
    }
}
