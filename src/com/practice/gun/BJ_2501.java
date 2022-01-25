package com.practice.gun;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2501 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (n % i == 0) list.add(i);
        }

        if (list.size() < k) System.out.println(0);
        else System.out.println(list.get(k - 1));

    }

}
