package com.practice.WJStudy;

import java.util.*;

public class BJ_2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> smallPeople = new ArrayList<>();

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            int tall = sc.nextInt();
            smallPeople.add(tall);
            sum += tall;
        }
        Collections.sort(smallPeople);
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - smallPeople.get(i) - smallPeople.get(j) == 100) {
                    for (int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;
                        System.out.println(smallPeople.get(k));
                    }
                    System.exit(0);
                }
            }
        }

    }

}

