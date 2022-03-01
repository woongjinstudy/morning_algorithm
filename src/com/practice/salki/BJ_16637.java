package com.practice.salki;

import java.util.Scanner;

public class BJ_16637 {

    public static int n;
    public static String tmp;
    public static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        tmp = sc.next();

        dfs(2,tmp.charAt(0)-'0');

        System.out.println(answer);
    }

    public static void dfs(int idx, int total){

        if(idx>tmp.length()-1){
            answer = Math.max(total, answer);
            return;
        }

        char oper = tmp.charAt(idx-1);

        if(idx+2<tmp.length()){
            int sum = cal(tmp.charAt(idx)-'0',tmp.charAt(idx+2)-'0', tmp.charAt(idx+1));
            int sumTotal = cal(total, sum, oper);
            dfs(idx+4, sumTotal);
        }
        dfs(idx+2, cal(total,tmp.charAt(idx)-'0',oper));
    }

    public static int cal(int a, int b, char op){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
        }
        return 0;
    }
}

