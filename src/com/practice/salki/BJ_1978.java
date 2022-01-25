package com.practice.salki;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        while(n>1){
            int tmp = sc.nextInt();
            boolean check = false;
            if(tmp<2) continue;
            for(int j=2; j<tmp; j++){
                if(tmp%j==0){
                    check = true;
                    break;
                }
            }
            if(!check) result++;
            n--;
        }
//        System.out.println(n);
        System.out.println(result);
    }
}

