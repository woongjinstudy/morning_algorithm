package com.practice.gun;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1916 {

    static ArrayList<ArrayList<Edge1916>> graph;
    static int[] dis;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n + 1];

        graph = new ArrayList<ArrayList<Edge1916>>();
        for (int i = 0; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
            graph.add(new ArrayList<Edge1916>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge1916(b, c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        solution(start, end);

        System.out.println(dis[end]);

    }

    private static void solution(int start, int end) {

        PriorityQueue<Edge1916> pq = new PriorityQueue<>();
        pq.offer(new Edge1916(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Edge1916 tmp = pq.poll();

            int now = tmp.vex;
            int nowCost = tmp.cost;
            if (nowCost > dis[now]) continue;

            for (Edge1916 e : graph.get(now)) {
                if (dis[e.vex] > nowCost + e.cost) {
                    dis[e.vex] = nowCost + e.cost;
                    pq.offer(new Edge1916(e.vex, nowCost + e.cost));
                }
            }

        }

    }

}

class Edge1916 implements Comparable<Edge1916> {
    int vex; //정점
    int cost; //비용

    Edge1916(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }


    @Override
    public int compareTo(Edge1916 o) {
        return this.cost - o.cost;
    }
}