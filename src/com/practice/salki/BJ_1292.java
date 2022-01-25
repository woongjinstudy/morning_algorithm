package com.practice.salki;

import java.util.Scanner;

public class BJ_1292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int idx = 0;
        int tmp = 0;
        int[] arr = new int[2000];
        while(idx<1000){
            tmp++;
            for(int i=tmp; i<2*tmp; i++){
                arr[idx] = tmp;
                idx++;
            }
        }
        int result = 0;
        for(int i=min-1; i<max; i++){
            result += arr[i];
        }

        System.out.println(result);
    }
}

