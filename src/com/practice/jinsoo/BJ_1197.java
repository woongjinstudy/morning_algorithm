package com.practice.jinsoo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_1197 {
    static int parent[];
    static class Edge {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }
    static ArrayList<Edge> list = new ArrayList<>();;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        parent = new int[v + 1];
        for (int i = 1; i < v + 1; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < e; i++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int cost = sc.nextInt();

            list.add(new Edge(V,E,cost));
        }
        list.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.v, e2.v);
            }
        });

        int res = 0;
        for (Edge node : list) {
            if (find(node.s) != find(node.e)) {
                union(node.s, node.e);
                res += node.v;
            }
        }
        System.out.println(res);

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
