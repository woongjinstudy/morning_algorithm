package com.practice.gun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1978 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int length = Collections.max(list) + 1;
        boolean[] arr = new boolean[length];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i * i < length; i++) {
            for (int j = i * i; j < length; j += i) arr[j] = true;
        }

        int cnt = 0;
        for (int i : list) {
            if (arr[i] == false) cnt++;
        }

        System.out.println(cnt);

        sc.close();

    }

}
