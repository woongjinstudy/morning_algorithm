package com.practice.yeseul;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BJ_5430 {
    static Deque<String> deque = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String function = sc.next();
            int n = sc.nextInt();
            String arrStr = sc.next();
            for (String s : arrStr.substring(1, arrStr.length() - 1).split(",")) {
                if (!s.equals("")) deque.add(s);
            }
            System.out.println(getAnswer(function, n));
        }
    }

    private static String getAnswer(String function, int n) {
        boolean isFront = true;

        for (int i = 0; i < function.length(); i++) {
            if (function.charAt(i) == 'R') {
                isFront = !isFront;
            } else { // 'D'
                if (deque.isEmpty()) return "error";
                if (isFront) deque.pollFirst();
                else deque.pollLast();
            }
        }

        StringBuilder answer = new StringBuilder();
        answer.append("[");
        if (isFront) {
            while (!deque.isEmpty()) {
                if (deque.size() > 1) answer.append(deque.pollFirst() + ",");
                else answer.append(deque.pollFirst());
            }
        }
        if (!isFront) {
            while (!deque.isEmpty()) {
                if (deque.size() > 1) answer.append(deque.pollLast() + ",");
                else answer.append(deque.pollLast());
            }
        }
        return answer.append("]").toString();
    }
}
