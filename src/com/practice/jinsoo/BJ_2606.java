package com.practice.jinsoo;

import java.util.Scanner;

public class BJ_2606 {
    static int parent[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n+1];

        for(int i=1; i<=n; i++) {
            parent[i] = i;
        }
        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x, y);
        }
        sc.close();
        int count = 0;
        int root = find(1);

        for (int i = 2; i <= n; i++)
            if (find(i) == root) count++;

        System.out.println(count);
    }

    public static int find(int a) {
        if (a == parent[a]) {
            return a;
        }
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) {
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
}
