package com.practice.yeseul;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_16953 {
    static class Pair {
        long num;
        int cnt;

        Pair(long num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(getAnswer(a, b));
    }

    private static int getAnswer(int a, int b) {
        Queue<Pair> queue = new LinkedList<Pair>();
        queue.add(new Pair(a, 1));
        while (!queue.isEmpty()) {
            Pair queuePair = queue.remove();
            long queueNum = queuePair.num;
            int queueCnt = queuePair.cnt;
            if (queueNum == b) {
                return queueCnt;
            }
            long tmpNum = queueNum * 2;
            if (tmpNum <= b) {
                queue.add(new Pair(tmpNum, queueCnt + 1));
            }
            tmpNum = queueNum * 10 + 1;
            if (tmpNum <= b) {
                queue.add(new Pair(tmpNum, queueCnt + 1));
            }
        }
        return -1;
    }
}
