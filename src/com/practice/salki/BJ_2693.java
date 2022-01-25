package com.practice.salki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_2693 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList result = new ArrayList();
        while(t>0){
            ArrayList arr = new ArrayList();
            for(int i=0; i<10; i++){
                arr.add(sc.nextInt());
            }
            arr.sort(Comparator.reverseOrder());
            result.add(arr.get(2));
            t--;
        }

        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }


    }
}

