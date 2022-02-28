package com.practice.yeseul;

import java.util.Scanner;

public class BJ_16637 {
    static int n;
    static String str;
    static int maxNum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        str = sc.next();
        getAnswer(0, 0);
        System.out.println(maxNum);
    }

    private static void getAnswer(int value, int idx) {
        if (idx >= n) {
            maxNum = Math.max(maxNum, value);
            return;
        }
        char op = idx - 1 >= 0 ? str.charAt(idx - 1) : '+';

        int tmpNum = calculate(value, op, str.charAt(idx) - '0');
        getAnswer(tmpNum, idx + 2); //(3,2)

        if (idx + 2 < n) {
            tmpNum = calculate(str.charAt(idx) - '0', str.charAt(idx + 1), str.charAt(idx + 2) - '0');
            tmpNum = calculate(value, op, tmpNum);
            getAnswer(tmpNum, idx + 4);
        }
    }

    private static int calculate(int num1, char op, int num2) {
        if (op == '+') return num1 + num2;
        else if (op == '-') return num1 - num2;
        else return num1 * num2;

    }


}
