package com.practice.salki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BJ_1197 {
    public static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        sc.nextLine();

        parent = new int[v+1];

        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        int result = 0;

        ArrayList<Edge> q = new ArrayList<>();

        for(int i=0; i<e; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int weight = sc.nextInt();
            q.add(new Edge(src, dest, weight));
        }
        int size = q.size();
        Collections.sort(q);
        for(int i=0; i<size; i++){
            Edge edge = q.get(i);
            int a = find(edge.getSrc());
            int b = find(edge.getDest());
            if(a!=b){
                result += edge.getWeight();
                union(a,b);
            }

        }
        System.out.println(result);

    }

    public static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b){
        int pa = parent[a];
        int pb = parent[b];
        if(pa==pb) return;
        if(pa<pb)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;

        public Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSrc(){
            return this.src;
        }
        public int getDest(){
            return this.dest;
        }
        public int getWeight(){
            return this.weight;
        }

        @Override
        public int compareTo(Edge o) {
            if(this.weight>o.weight)return 1;
            return -1;
        }
    }


}

