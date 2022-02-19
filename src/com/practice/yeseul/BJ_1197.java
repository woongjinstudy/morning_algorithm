package com.practice.yeseul;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BJ_1197 {
    static int parent[];

    static class Edge {
        int v1;
        int v2;
        int price;

        public Edge(int v1, int v2, int price) {
            this.v1 = v1;
            this.v2 = v2;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Edge> edges = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int price = sc.nextInt();
            edges.add(new Edge(v1, v2, price));
        }

        //price 오름차순으로 sorting
        edges.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return Integer.compare(e1.price, e2.price);
            }
        });

        System.out.println(getAnswer(edges));
    }

    private static int getAnswer(ArrayList<Edge> edges) {
        int sum = 0;
        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (getParent(edge.v1) != getParent(edge.v2)) {
                unionParent(edge.v1, edge.v2);
                sum += edge.price;
            }
        }
        return sum;
    }

    private static int getParent(int n) {
        if (parent[n] == n) return n;
        else return getParent(parent[n]);
    }

    private static void unionParent(int n1, int n2) {
        n1 = getParent(n1);
        n2 = getParent(n2);
        if (n1 < n2) parent[n2] = n1;
        else parent[n1] = n2;
    }
}
