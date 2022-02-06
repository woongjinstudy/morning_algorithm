package com.practice.jinsoo;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1700 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, k;
        n = sc.nextInt();
        k = sc.nextInt();
        ArrayList<Integer> tabs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tabs.add(0);
        }

        int[] schedule = new int[k + 1];
        for(int i = 0; i < k; ++i){
            schedule[i] = sc.nextInt();
        }
        int res = 0;

        for (int j = 0; j < k; j++) {
            if (tabs.contains(schedule[j])) {
                continue;
            } else if (tabs.contains(0)) {
                int index = tabs.indexOf(0);
                tabs.set(index, schedule[j]);
            } else {
                int tmp = 0;
                int cnt = 0;
                for (int tab : tabs) {
                    if (chkNotIn(tab, schedule, j)) {
                        tmp = tab;
                        continue;
                    } else if(findIndexAfterUse(tab, schedule, j) > cnt) {
                        cnt = findIndexAfterUse(tab, schedule, j);
                        tmp = tab;
                    }
                }
                tabs.set(tabs.indexOf(tmp), schedule[j]);
                res += 1;
            }
        }
        System.out.println(res);
    }

    static boolean chkNotIn(int tab, int[] schedule, int index) {
        boolean chk = true;
        for (int i = index; i < schedule.length; i++) {
            if (tab == schedule[i]) {
                chk =  false;
            }
        }
        return chk;
    }

    static int findIndexAfterUse(int tab, int[] schedule, int index) {
        int res = 0;
        for (int i = index; i < schedule.length; i++) {
            if (tab == schedule[i]) {
                res = i;
            }
        }
        return res;
    }
}
