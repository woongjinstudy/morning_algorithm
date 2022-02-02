package com.practice.salki;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class BJ_1700 {

    public static int n,k;
    public static ArrayList<Integer> arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new ArrayList<>();
        int[] tmpArr = new int[k];
        int count = 0;

        for(int i=0; i<k; i++){
            tmpArr[i] = sc.nextInt();
        }

        for(int i=0; i<k; i++) {
            int tmp = tmpArr[i];
            if (arr.size() < n&&!arr.contains(tmp)) {
                arr.add(tmp);
            } else {
                if (arr.contains(tmp)) {
                    continue;
                } else {
                    int cnt = 0;
                    int idx = 0;
                    ArrayList<Integer> newArr = new ArrayList<>();
                    while (cnt < n) {
                        if (i + idx == k) break;
                        if (arr.contains(tmpArr[i + idx])) {
                            idx++;
                            continue;
                        }
                        if (newArr.contains(tmpArr[i + idx])) {
                            idx++;
                            continue;
                        }
                        newArr.add(tmpArr[i + idx]);
                        cnt++;
                        count++;
                        idx++;
                    }
                    if(newArr.size()==n) {
                        arr.removeAll(arr);
                        arr.addAll(newArr);
                        i += n;
                    }
                }
            }
        }
        System.out.println(count);
    }


}

