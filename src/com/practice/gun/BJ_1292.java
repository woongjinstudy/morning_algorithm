package com.practice.gun;

import java.util.Scanner;

public class BJ_1292 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int lt = 0, rt = 0; // lt: a가 속한 값, rt: b가 속한 값
        int ltLast = 0, rtLast = 0; // a가 속한 값의 최대 순서, b가 속한 값의 최소 순서

        int k = 1;
        int sum = 1;
        boolean flag = false;
        if (a == k) {
            lt = k;
            ltLast = k;
            flag = true;
        }
        while (k <= b) {
            k++;
            sum += k;
            if (!flag && sum >= a) {
                lt = k;
                ltLast = sum;
                flag = true;
            }
            if (sum >= b) {
                rt = k;
                rtLast = sum - k;
                break;
            }
        }

        int answer = 0;
        if (lt == rt) {
            answer += (b - a + 1) * lt;
        } else {
            answer += (ltLast - a + 1) * lt;
            answer += (b - rtLast) * rt;
        }

        for (int i = lt + 1; i < rt; i++) {
            answer += i * i;
        }

        System.out.println(answer);

    }

}
