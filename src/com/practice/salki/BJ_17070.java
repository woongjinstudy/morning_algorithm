package com.practice.salki;

import java.util.*;

public class BJ_17070 {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int result = 0;

    public static int[][] karo = {{0,1},{1,1}};
    public static int[][] sero = {{1,0},{1,1}};
    public static int[][] daeKak = {{0,1},{1,0},{1,1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                int tmp = sc.nextInt();
                map[i][j] = tmp;
                if(tmp==1) visited[i][j] = true;
            }
        }
        dfs(1,0, 0);
        System.out.println(result);
    }

    public static void dfs(int x, int y, int dir){
        if(x==n-1&&y==n-1){
            result++;
        }
        switch (dir){
            //가로로 들어왔을때
            case 0:
                for(int i=0; i< karo.length; i++)
                {
                    int dx = karo[i][1];
                    int dy = karo[i][0];
                    int nextX = x+dx;
                    int nextY = y+dy;
                    if(nextX<n&&nextY<n&&!visited[nextY][nextX]&&map[nextY][nextX]==0) {
                        visited[nextY][nextX] = true;
                        if(i==0) dfs(nextX, nextY, 0);
                        else if(i==1) dfs(nextX, nextY, 2);
                        visited[nextY][nextX] = false;
                    }
                }
                break;
            //세로로 들어왔을때
            case 1:
                for(int i2=0; i2< sero.length; i2++)
                {
                    int dx = sero[i2][1];
                    int dy = sero[i2][0];
                    int nextX = x+dx;
                    int nextY = y+dy;
                    if(nextX<n&&nextY<n&&!visited[nextY][nextX]&&map[nextY][nextX]==0) {
                        visited[nextY][nextX] = true;
                        if(i2==0) dfs(nextX, nextY, 1);
                        else if(i2==1) dfs(nextX, nextY, 2);
                        visited[nextY][nextX] = false;
                    }
                }
                break;
            //대각선으로 들어왔을때
            case 2:
                for(int i3=0; i3< daeKak.length; i3++)
                {
                    int dx = daeKak[i3][1];
                    int dy = daeKak[i3][0];
                    int nextX = x+dx;
                    int nextY = y+dy;
                    if(nextX<n&&nextY<n&&!visited[nextY][nextX]&&map[nextY][nextX]==0) {
                        visited[nextY][nextX] = true;
                        if(i3==0) dfs(nextX, nextY, 0);
                        else if(i3==1) dfs(nextX, nextY, 1);
                        else if(i3==2) dfs(nextX, nextY, 2);
                        visited[nextY][nextX] = false;
                    }
                }
                break;
        }
    }






}

