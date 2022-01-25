package com.practice.WJStudy;

import java.util.Scanner;

public interface BJ_2581 {
    public static void main(String[] args) {
        boolean prime[] = new boolean[10001];
        int MAX = 1000;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        prime[0] = prime[1] = true;

        for(int i=2; i*i<=n; i++){
            // prime[i]가 소수라면
            if(!prime[i]){
                // prime[j] 소수가 아닌 표시
                for(int j=i*i; j<=n; j+=i) prime[j]=true;
            }
        }
        int sum = 0;
        int min = 0;
        boolean chk = true;

        for (int j = m; j <= n; j++) {
            if(!prime[j]){
                if (chk) {
                    min = j;
                    sum += j;
                    chk = false;
                }
                else{
                    sum += j;
                }
            }
        }
        if (chk) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
