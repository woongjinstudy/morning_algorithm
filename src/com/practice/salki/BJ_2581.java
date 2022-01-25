package com.practice.salki;

import java.util.Scanner;

public class BJ_2581 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int resultMin = 10001;
        int resultSum = 0;
        for(int i=min; i<=max; i++){
            if(i<2) continue;
            boolean check = true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0)
                {
                    check = false;
                    break;
                }
            }
            if(check){
                resultSum += i;
                if(resultMin > i) resultMin = i;
            }
        }
        if(resultSum==0) System.out.println(-1);
        else {
            System.out.println(resultSum);
            System.out.println(resultMin);
        }

    }
}

