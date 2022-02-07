package com.practice.salki;

import java.util.Scanner;

public class BJ_1916 {
    public static int[] arr;

    public static int n;
    public static int s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        s = sc.nextInt();

        sc.nextLine();

        arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int left = 0, right = 0, sum = 0, ans = 100001;
        boolean flag = false;
        while(true){
            if(sum>=s){
                sum -= arr[left];
                ans = Math.min(ans, right-left);
                flag = true;
                left++;
            }else if(right == n){
                break;
            }else{
                sum += arr[right];
                right++;
            }
        }
        if(flag) System.out.println(ans);
        else System.out.println(0);

    }



}

