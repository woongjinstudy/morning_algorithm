package com.practice.jinsoo;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_16637 {

    static int n;
    static int res = -(int) Math.pow(2, 31);
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String input = sc.next();
        for (int i = 0; i < n; i++) {
            char next = input.charAt(i);
            if(next >= '0' && next <= '9') nums.add(Character.getNumericValue(next));
            else ops.add(next);
        }
        dfs(0, nums.get(0));
        System.out.println(res);
    }

    public static int cal(int a, int b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else {
            return a * b;
        }
    }

    public static void dfs(int i, int sum) {
        if (i == ops.size()) {
            res = Math.max(res, sum);
        } else {
            dfs(i + 1, cal(sum, nums.get(i + 1), ops.get(i)));
            if (i + 2 <= ops.size()) { // 뒤에 연산자 하나 더 있으면
                dfs(i+2, cal(sum, cal(nums.get(i+1), nums.get(i+2), ops.get(i+1)), ops.get(i)));
            }
        }
    }
}
