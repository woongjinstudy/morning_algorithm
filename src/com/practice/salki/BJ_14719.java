package com.practice.salki;

import java.util.Scanner;
import java.util.Stack;

public class BJ_14719 {

    public static int[] height;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = 0;
        int w = 0;

        h = sc.nextInt();
        w = sc.nextInt();
        height = new int[w];
        for(int i=0; i<w; i++){
            height[i] = sc.nextInt();
        }

        int answer = 0;
        for(int i=1; i<w-1; i++){
            int left = 0;
            int right = 0;
            for(int j=0; j<i; j++){
                left = Math.max(height[j], left);
            }
            for(int j=i+1; j<w; j++){
                right = Math.max(height[j], right);
            }
            int tmp = Math.min(left, right);
            if(height[i]<tmp){
                answer += tmp-height[i];
            }
        }
        System.out.println(answer);



    }
}

