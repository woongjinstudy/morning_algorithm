package com.practice.gun;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BJ_1911 {
    static int n, l;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        ArrayList<Hole> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Hole(s, e));
        }

        Collections.sort(list);

        int cnt = 0;
        int nextStart = 0;

        for (int i = 0; i < n; i++) {
            Hole tmp = list.get(i);
            if (nextStart > tmp.start) tmp.start = nextStart;
            if (tmp.start > tmp.end) continue;

            int length = tmp.end - tmp.start;

            int num = 0;

            if (length % l == 0) {
                num = length / l;
            } else {
                num = length / l + 1;
            }

            cnt += num;

            nextStart = tmp.start + num * l;

        }

        bw.write(cnt + "");

        bw.flush();
        bw.close();
        br.close();

    }
}

class Hole implements Comparable<Hole> {
    int start;
    int end;

    Hole(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Hole o) {
        if (this.start == o.start) {
            return this.end - o.end;
        } else
            return this.start - o.start;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
