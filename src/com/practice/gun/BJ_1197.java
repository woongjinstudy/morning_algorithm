package com.practice.gun;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1197 {

    static int[] unf;

    public static int Find(int v) {
        if (v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }

    public static void Union(int a, int b) {
        int fa = Find(a);
        int fb = Find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];
        for (int i = 0; i < v + 1; i++) {
            unf[i] = i;
        }
        ArrayList<Edge1700> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();
            list.add(new Edge1700(v1, v2, cost));
        }

        Collections.sort(list);

        int answer = 0;

        for (Edge1700 edge : list) {
            int v1 = Find(edge.v1);
            int v2 = Find(edge.v2);
            if (v1 != v2) {
                answer += edge.cost;
                Union(edge.v1, edge.v2);
            }
        }

        System.out.println(answer);

    }


}

class Edge1700 implements Comparable<Edge1700> {
    int v1;
    int v2;
    int cost;

    Edge1700(int v1, int v2, int cost) {
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge1700 o) {
        return this.cost - o.cost;
    }

}