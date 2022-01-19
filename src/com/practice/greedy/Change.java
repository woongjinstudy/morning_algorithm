package com.practice.greedy;

public class Change {
    public static void main(String[] args) {

        int[] coinTypes = {500, 100, 50, 10};
        int cnt = 0;

        int n = 1260;

        for (int i = 0; i < 4; i++) {
            int coin = coinTypes[i];
            cnt += n / coin;
            n %= coin;
        }

        System.out.println(cnt);
    }
}
