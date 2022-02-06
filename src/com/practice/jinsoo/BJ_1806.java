package com.practice.jinsoo;

import java.io.*;
import java.util.*;

public class BJ_1806 {

    static int[] list;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        list = new int[n+1];
        for (int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int res = n+1;

        while (true) {
            if(sum >= s) {
                res = Math.min(res, end - start);
                sum -= list[start++];
            } else if (end == n) {
                break;
            } else {
                sum += list[end++];
            }
        }
        if (res == n+1) {
            System.out.println(0);
        }
        else System.out.println(res);
    }
}
