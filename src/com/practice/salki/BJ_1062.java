package com.practice.salki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ_1062 {

    public static int n,k;
    public static String[] word;
    public static int max = 0;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        visited = new boolean[26];
        n = sc.nextInt();
        k = sc.nextInt();
        sc.nextLine();
        word = new String[n];
        for(int i=0; i<n; i++){
            String str = sc.nextLine();
            str = str.substring(4);
            str = str.substring(0,str.length()-4);
            word[i] = str;
        }

        if(k<5){
            System.out.println(0);
            return;
        }else if(k==26){
            System.out.println(n);
            return;
        }

        visited['a'-'a'] = true;
        visited['n'-'a'] = true;
        visited['t'-'a'] = true;
        visited['i'-'a'] = true;
        visited['c'-'a'] = true;


        test(0,0);
        System.out.println(max);

    }

    public static void test(int idx, int len){
        if(len==k-5){
            int cnt = 0;
            for (int i=0; i<n; i++){
                boolean flag = true;
                for(int j=0; j<word[i].length(); j++){
                    if(!visited[word[i].charAt(j)-'a']){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    cnt++;
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        for(int i=idx; i<26; i++)
        {
            if(!visited[i]) {
                visited[i] = true;
                test(i, len + 1);
                visited[i] = false;
            }
        }

    }


}

