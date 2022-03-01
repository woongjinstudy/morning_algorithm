package com.practice.salki;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ_2606 {

    public static ArrayList<ArrayList<Integer>> node;
    public static int answer;
    public static boolean[] visited = new boolean[101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();
        int k = sc.nextInt();

        for(int i=0; i<=n; i++)
        {
            node.add(new ArrayList());
        }

        for(int i=0; i<k; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();

            node.get(start).add(end);
            node.get(end).add(start);
            sc.nextLine();
        }

        answer = 0;

        Queue<Integer> q = new LinkedList();

        q.add(1);

        while(!q.isEmpty()){
            int idx = q.poll();
            if(visited[idx]) continue;
            visited[idx] = true;
            answer++;
            for(int i=0; i<node.get(idx).size(); i++)
            {
                if(!visited[node.get(idx).get(i)]) q.add(node.get(idx).get(i));

            }
        }
        System.out.println(answer-1);
    }



}

