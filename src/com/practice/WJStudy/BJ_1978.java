package com.practice.WJStudy;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_1978 {

    public static void main(String[] args) {
        boolean prime[] = new boolean[1001];
        ArrayList<Integer> prime_chk = new ArrayList<>();
        int MAX = 1000;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        prime[0] = prime[1] = true;

        for(int i=2; i*i<=MAX; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=MAX; j+=i) prime[j]=true;
            }
        }

        for (int i = 0; i < n; i++) {
            prime_chk.add(sc.nextInt());
        }
        int res = 0;
        for (int chk : prime_chk) {
            if (!prime[chk]) {
                res++;
            }
        }
        System.out.println(res);
    }
}
