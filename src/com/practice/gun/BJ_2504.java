package com.practice.gun;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2504 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] arr = sc.next().split("");

        Stack<String> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("(") || s.equals("[")) {
                stack.push(s);
            } else {
                if (s.equals(")")) {

                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")") && !stack.peek().equals("[") && !stack.peek().equals("]")) {
                                int top = Integer.parseInt(stack.pop());
                                stack.push(Integer.toString(top + 2));
                            } else stack.push("2");
                        } else if (stack.peek().equals(")") || stack.peek().equals("]") || stack.peek().equals("[")) {
                            System.out.println(0);
                            return;
                        } else {
                            int top = Integer.parseInt(stack.pop());
                            if (!stack.isEmpty() && stack.peek().equals("(")) {
                                stack.pop();

                                if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")") && !stack.peek().equals("[") && !stack.peek().equals("]")) {
                                    int second = Integer.parseInt(stack.pop());
                                    stack.push(Integer.toString(second + top * 2));
                                } else stack.push(Integer.toString(top * 2));
                            } else {
                                System.out.println(0);
                                return;
                            }
                        }
                    }

                } else {
                    if (stack.isEmpty()) {
                        System.out.println(0);
                        return;
                    } else {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")") && !stack.peek().equals("[") && !stack.peek().equals("]")) {
                                int top = Integer.parseInt(stack.pop());
                                stack.push(Integer.toString(top + 3));
                            } else stack.push("3");
                        } else if (stack.peek().equals(")") || stack.peek().equals("]") || stack.peek().equals("(")) {
                            System.out.println(0);
                            return;
                        } else {
                            int top = Integer.parseInt(stack.pop());
                            if (!stack.isEmpty() && stack.peek().equals("[")) {
                                stack.pop();
                                if (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals(")") && !stack.peek().equals("[") && !stack.peek().equals("]")) {
                                    int second = Integer.parseInt(stack.pop());
                                    stack.push(Integer.toString(second + top * 3));
                                } else stack.push(Integer.toString(top * 3));
                            } else {
                                System.out.println(0);
                                return;
                            }
                        }
                    }
                }
            }
        }

        if (stack.size() != 1 || stack.peek().equals("(") || stack.peek().equals(")") || stack.peek().equals("[") || stack.peek().equals("]")) {
            System.out.println(0);
        } else System.out.println(stack.pop());

    }

}
