package com.practice.salki;

import java.util.*;

public class BJ_17070 {

    public static int n;
    public static int[][] map;
    public static boolean[][] visited;
    public static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System .in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(0,1, 0);
        System.out.println(result);
    }

    private static void dfs(int y, int x, int dir){
        if(x==n-1&&y==n-1&&map[y][x]!=1){
            result++;
            return;
        }
        if(dir==0) {
            if (check(y, x + 1) && map[y][x + 1] == 0){
                dfs(y, x + 1, 0);
            }
            if (check(y + 1, x + 1) && map[y + 1][x + 1] == 0 && map[y + 1][x] == 0 && map[y][x + 1] == 0){
                dfs(y + 1, x + 1, 2);
            }
        }
        else if(dir==1){
            if(check(y+1, x) && map[y+1][x] == 0){
                dfs(y+1, x, 1);
            }
            if(check(y+1, x+1) && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0){
                dfs(y+1, x+1, 2);
            }
        }else if(dir==2){

            if(check(y, x+1) && map[y][x+1] == 0){
                dfs(y, x+1, 0);
            }
            if(check(y+1, x) && map[y+1][x] == 0){
                dfs(y+1,x, 1);
            }
            if(check(y+1, x+1) && map[y+1][x+1] == 0 && map[y+1][x] == 0 && map[y][x+1] == 0){
                dfs(y+1,x+1,2);
            }
        }
    }
    private static boolean check(int nextY, int nextX){
        return nextX>=0&&nextY>=0&&nextX<n&&nextY<n;
    }






}

