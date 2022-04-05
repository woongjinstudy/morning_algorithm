package com.practice.yeseul;

import java.util.Scanner;

public class BJ_17136 {
    static int map[][] = new int[10][10];
    static int paperCnt[] = {0, 5, 5, 5, 5, 5};
    static int allCnt = 0;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        getAnswer(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    private static void getAnswer(int x, int y) {
        if (x == 10 && y != 10) {
            getAnswer(0, y + 1);
            return;
        }
        if (y == 10) {
            answer = Math.min(allCnt, answer);
            return;
        }
        if (map[x][y] == 0) {
            getAnswer(x + 1, y);
            return;
        }

        for (int size = 5; size >= 1; size--) {
            if (x + size > 10 || y + size > 10 || paperCnt[size] == 0) continue;

            boolean isPossible = true;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (map[x + i][y + j] == 0) {
                        isPossible = false;
                        break;
                    }
                }
                if (!isPossible) break;
            }
            if (!isPossible) continue;
            else {
                changeMapNum(x, y, 0, size);
                getAnswer(x + size, y);
                changeMapNum(x, y, 1, size);
            }
        }
    }

    private static void changeMapNum(int x, int y, int number, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[x + i][y + j] = number;
            }
        }
        if (number == 1) { //색종이 덮은거 X
            paperCnt[size]++;
            allCnt--;
        } else { // 색종이 덮기
            paperCnt[size]--;
            allCnt++;
        }
    }
}
