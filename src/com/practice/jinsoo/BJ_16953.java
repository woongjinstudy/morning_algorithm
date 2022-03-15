package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_16953 {
    static int a;
    static int b;
    static int res = -1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        cal(b, 1);
        System.out.println(res);
    }

    public static void cal(int b, int total) {
        if (b < a) return;
        else if (b == a) {
            res = Math.max(res, total);
            return;
        } else {
            String num = String.valueOf(b);
            char[] digits1 = num.toCharArray();
            if (b % 2 == 0) {
                cal(b / 2, total + 1);
            }
            if (Character.compare('1', digits1[digits1.length - 1]) == 0) {
                String tmp = num.substring(0, num.length()-1);
                cal(Integer.valueOf(tmp), total + 1);
            }
        }


    }
}
