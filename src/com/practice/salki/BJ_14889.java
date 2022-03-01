package com.practice.salki;

import java.util.Scanner;

public class BJ_14889 {

    public static int[][] map;
    public static int n;
    public static int answer = Integer.MAX_VALUE;
    public static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();
        map = new int[n][n];
        visited = new boolean[n];
        for(int i=0; i<n; i++){
           for(int j=0; j<n; j++){
               map[i][j] = sc.nextInt();
           }
           sc.nextLine();
        }

        dfs(0,0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt){

        if(cnt==n/2){
            int start = 0;
            int link = 0;
            for(int i=0; i<n-1; i++)
            {
                for(int j=i; j<n; j++){
                    if(visited[i]&&visited[j]){
                        start += map[i][j];
                        start += map[j][i];
                    }
                    else if(!visited[i]&&!visited[j]){
                        link += map[i][j];
                        link += map[j][i];
                    }
                }
            }
            if(start>link){
                answer = Math.min(answer, start-link);
            }else{
                answer = Math.min(answer, link-start);
            }
        }

        for(int i=idx; i<n; i++){
            visited[i] = true;
            dfs(i+1,cnt+1);
            visited[i] = false;
        }
    }



}

