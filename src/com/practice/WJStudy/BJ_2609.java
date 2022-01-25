package com.practice.WJStudy;

import java.util.Scanner;

public class BJ_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = a*b;

        int gcp = 1;
        while(true){
            if (a >= b){
                if (a % b == 0){
                    gcp = b;
                    break;
                } else{
                    b = a % b;
                    a = b;
                }
            } else{
                if (b % a == 0){
                    gcp = a;
                    break;
                } else{
                    a = b % a;
                    b = a;
                }
            }
        }

        System.out.println(gcp);
        System.out.print(x / gcp );
    }
}
