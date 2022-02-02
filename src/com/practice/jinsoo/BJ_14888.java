package com.practice.jinsoo;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_14888 {

    static int n = 0;
    static int add = 0, sub = 0, mul = 0, div = 0;
    static int min = 100000000;
    static int max = -100000000;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        add = sc.nextInt();
        sub = sc.nextInt();
        mul = sc.nextInt();
        div = sc.nextInt();

        dfs(1, list.get(0));
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int cnt, int val) {
        if (cnt == n) {
            min = min > val ? val : min;
            max = max < val ? val : max;
        }
        else{
            if (add > 0) {
                add -= 1;
                dfs(cnt + 1, val + list.get(cnt));
                add += 1;
            }
            if (sub > 0) {
                sub -= 1;
                dfs(cnt + 1, val - list.get(cnt));
                sub += 1;
            }
            if (mul > 0) {
                mul -= 1;
                dfs(cnt + 1, val * list.get(cnt));
                mul += 1;
            }
            if (div > 0) {
                div -= 1;
                dfs(cnt + 1, val /list.get(cnt));
                div += 1;
            }
        }
    }
}
