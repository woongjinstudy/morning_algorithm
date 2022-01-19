package com.practice.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BigNumRule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n,m,k 공백을 기준으로 입력받기
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        // n개의 수를 공백을 기준으로 입력받기
        int[] arr = new int[n];
        for(int i=0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        //정렬
        Arrays.sort(arr);
        int first = arr[n - 1];
        int second = arr[n - 2];

//        System.out.println(Arrays.toString(arr));
        //
        int cnt = (m / (k + 1)) * k;
        cnt += m % (k + 1);

        int result = 0;
        result += cnt * first;
        result += (m - cnt) * second;

        System.out.println(result);
    }

}
