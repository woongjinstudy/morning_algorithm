package com.practice.salki;

import java.util.Scanner;

public class BJ_2798 {

    public static int n;
    public static int m;
    public static int[] arr = new int[101];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int max = 0;

        for (int i = 0; i < n-2; i++)
        {
            int a = arr[i];
            for (int j = i + 1; j < n - 1; j++)
            {
                for (int k = j + 1; k < n; k++)
                {
                    sum = arr[i] + arr[j] + arr[k];
                    if ( sum >= max && sum <= m)
                    {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);

    }
}

