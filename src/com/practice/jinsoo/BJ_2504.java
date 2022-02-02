package com.practice.jinsoo;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2504 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Stack<String> stack = new Stack<>();
        int round = 0;
        int square = 0;
        boolean chk = true;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case '(':
                    round++;
                    stack.push("(");
                    break;
                case ')':
                    round--;
                    if (round > -1) {
                        if (stack.peek().equals("(")) {
                            stack.pop();
                            stack.push("2");
                        } else {
                            int res = 0;
                            while (!stack.isEmpty()) {
                                if(stack.peek().equals("[") ||stack.peek().equals("]")){
                                    chk = false;
                                    return;
                                }
                                else if (stack.peek().equals("(")) {
                                    stack.pop();
                                    res *= 2;
                                    stack.push(String.valueOf(res));
                                    break;
                                } else {
                                    res += Integer.parseInt(stack.pop());
                                }
                            }
                        }
                    }
                    break;
                case '[':
                    square++;
                    stack.push("[");
                    break;
                case ']':
                    square--;
                    if (square > -1) {
                        if (stack.peek().equals("[")) {
                            stack.pop();
                            stack.push("3");
                        } else {
                            int res = 0;
                            while (!stack.isEmpty()) {
                                if (stack.peek().equals("(") || stack.peek().equals(")")) {
                                    chk = false;
                                    return;
                                } else if (stack.peek().equals("[")) {
                                    stack.pop();
                                    res *= 3;
                                    stack.push(String.valueOf(res));
                                    break;
                                } else {
                                    res += Integer.parseInt(stack.pop());
                                }

                            }
                        }
                    }
                    break;
                }
        }
        if (square != 0 || round != 0) {
            chk = false;
        }
        if (chk) {
            int result = 0;
            while(!stack.isEmpty()) {
                result += Integer.parseInt(stack.pop());
            }
            System.out.println(result);
        } else{
            System.out.println(0);
        }
    }
}
