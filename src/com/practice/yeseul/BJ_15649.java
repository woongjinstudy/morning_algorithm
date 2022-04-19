package com.practice.yeseul;

import java.util.Scanner;

public class BJ_15649 {
    static int n, m, numArray[];
    static boolean visit[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        numArray = new int[n];
        visit = new boolean[n + 1];

        getSequence(0);
    }

    private static void getSequence(int cnt) {
        if (cnt == m) {
            printNumArray();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                numArray[cnt] = i;
                visit[i] = true;
                getSequence(cnt + 1);
                visit[i] = false;
            }
        }
    }

    private static void printNumArray() {
        for (int i = 0; i < m; i++) {
            System.out.print(numArray[i] + " ");
        }
        System.out.println();
    }

}
