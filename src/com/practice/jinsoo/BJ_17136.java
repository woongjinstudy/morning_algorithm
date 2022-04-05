package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_17136 {
    static int[][] map = new int[10][10];
    static int[][] map2 =new int[10][10];
    static int[] paper = {5,5,5,5,5};
    static int[] paper2 = {5,5,5,5,5};
    static int total = 0;
    static int total2 = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int x = sc.nextInt();
                map[i][j] = x;
                map2[i][j] = x;
            }
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                attach(i, j);
            }
        }

        for (int i = 9; i >= 0; i--) {
            for (int j = 9; j >= 0; j--) {
                attach2(i, j);
            }
        }

        boolean chk1 = check_clean();
        boolean chk2 = check_clean2();
        if(chk1 && chk2){
            int res = total > total2 ? total2 : total;
            System.out.println(res);
        } else if(chk1){
            System.out.println(total);
        } else if(chk2){
            System.out.println(total2);
        }
        else{
            System.out.println(-1);
        }


    }

    public static int attach(int x, int y){
        for (int i = 5; i > 0; i--) {
            if(check_remain(i)){
                if (cal(x,y,i)) break;
            }
        }
        return 0;
    }

    public static int attach2(int x, int y){
        for (int i = 5; i > 0; i--) {
            if(check_remain2(i)){
                if (cal2(x,y,i)) break;
            }
        }
        return 0;
    }

    public static boolean cal(int x, int y, int k){
        int copy[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(map[i], 0, copy[i], 0, 10);
        }

        boolean tmp = true;
        for (int a = 0; a < k; a++) {
            if(!tmp) break;
            for (int b = 0; b < k; b++) {
                if(x+a <10 && y+b <10){
                    if(map[x+a][y+b] - 1 == -1) {
                        tmp = false;
                        break;
                    }else{
                        copy[x+a][y+b] = copy[x+a][y+b] -1;
                    }
                }
            }
        }
        if (tmp){
            paper[k - 1] = paper[k - 1] - 1;
            total += 1;
            map = copy;
            return true;
        } else return false;
    }

    public static boolean cal2(int x, int y, int k){
        int copy[][] = new int[10][10];
        for (int i = 0; i < 10; i++) {
            System.arraycopy(map2[i], 0, copy[i], 0, 10);
        }

        boolean tmp = true;
        for (int a = 0; a < k; a++) {
            if(!tmp) break;
            for (int b = 0; b < k; b++) {
                if(x-a >=0 && y-b >=0){
                    if(map2[x-a][y-b] - 1 == -1) {
                        tmp = false;
                        break;
                    }else{
                        copy[x-a][y-b] = copy[x-a][y-b] -1;
                    }
                }
            }
        }
        if (tmp){
            paper2[k - 1] = paper2[k - 1] - 1;
            total2 += 1;
            map2 = copy;
            return true;
        } else return false;
    }

    public static boolean check_remain(int k) {
        if (paper[k - 1] > 0) {
            return true;
        } else return false;

    }

    public static boolean check_remain2(int k) {
        if (paper2[k - 1] > 0) {
            return true;
        } else return false;

    }

    public static boolean check_clean(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(map[i][j] != 0) return false;
            }
        }
        return true;
    }

    public static boolean check_clean2(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(map2[i][j] != 0) return false;
            }
        }
        return true;
    }
}
