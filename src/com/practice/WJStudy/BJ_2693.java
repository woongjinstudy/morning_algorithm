package com.practice.WJStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< n; i++){
            for(int j=0; j< 10; j++) {
                list.add(sc.nextInt());
            }
            Collections.sort(list);
            result.add(list.get(7));
            list.clear();
        }
        for (int res : result) {
            System.out.println(res);
        }
    }
}
