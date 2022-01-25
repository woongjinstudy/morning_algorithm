package com.practice.gun;

import java.util.Scanner;

public class BJ_2609 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int gcf = 0; //greatest common factor : 최대공약수
        int lcm = 0; //least common multiple : 최대공배수

        if (a == b) {
            System.out.println(a);
            System.out.println(a);
            return;
        }

        if (a > b) { // 정렬
            int tmp = a;
            a = b;
            b = tmp;
        }


        for (int i = 1; i <= a; i++) {
            if (a % i == 0 && b % i == 0) gcf = i;
        }

        lcm = a * b / gcf;

        System.out.println(gcf);
        System.out.println(lcm);

    }

}
