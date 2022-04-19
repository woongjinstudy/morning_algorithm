package com.practice.yeseul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1911 {
    static class Water implements Comparable<Water> {
        int start;
        int end;

        public Water(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Water w) {
            if (this.start < w.start)
                return -1;
            else if (this.start > w.start)
                return 1;
            return 0;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        ArrayList<Water> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            list.add(new Water(start, end));
        }

        Collections.sort(list);

        int cnt = 0;
        int tmpStart = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int start = list.get(i).start; //1
            int end = list.get(i).end; //6
            if (start > tmpStart) {
                tmpStart = start;
            }
            while (tmpStart < end) {
                cnt++;
                tmpStart += l;
            }
        }
        System.out.println(cnt);
    }
}
