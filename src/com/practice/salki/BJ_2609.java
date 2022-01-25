package com.practice.salki;

import java.util.Scanner;

public class BJ_2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int abMulti = a * b;

        while(true){
            int r = a % b;
            a = b;
            b = r;
            if(r==0) {
                System.out.println(a);
                break;
            }
        }
        System.out.println(abMulti/a);

    }
}

