package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_14719 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H, W;
        int[] height = new int[501];
        H = sc.nextInt();
        W = sc.nextInt();
        for (int i = 0; i < W; i++) {
            height[i] = sc.nextInt();
        }
        int res = 0;
        for(int i=0;i<W;i++) {
            int left=i;
            for(int l=i;l>=0;l--) {
                if(height[l]>height[left]) left=l;
            }
            int right=i;
            for(int r=i;r<W;r++) {
                if(height[r]>height[right]) right=r;
            }
            int size=Math.min(height[left], height[right])-height[i];
            if(size>0) res+=size;
        }

        System.out.println(res);
    }
}
