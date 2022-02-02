package com.practice.salki;

import java.util.Scanner;

public class BJ_14888 {

    public static int min = 1000000000;
    public static int max = -1000000000;
    public static int len = 0;
    public static int[] oper = new int[4];
    public static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        len = n;
        arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        for(int i=0; i<4; i++){
            oper[i] = sc.nextInt();
        }

        dfs(arr[0], 1 );
        System.out.println(max);
        System.out.println(min);
    }
    public static void dfs(int num, int idx){
        if(idx==len){
            min = Math.min(num, min);
            max = Math.max(num, max);
            return;
        }
        for(int i=0; i<4; i++){
            if(oper[i]>0){
                oper[i]--;
                switch(i){
                    case 0:
                        dfs(num+arr[idx], idx+1);
                        break;
                    case 1:
                        dfs(num-arr[idx], idx+1);
                        break;
                    case 2:
                        dfs(num*arr[idx], idx+1);
                        break;
                    case 3:
                        dfs(num/arr[idx], idx+1);
                        break;
                }
                oper[i]++;
            }
        }
    }
}

