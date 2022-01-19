package com.practice.WJStudy;

import java.util.*;

public class BJ_2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // n,m 공백을 기준으로 입력받기
        int n = sc.nextInt();
        int k = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if(n%i == 0 ) k --;
            if (k == 0) {
                System.out.println(i);
                break;
            }
        }
        if (k != 0) {
            System.out.println(0);
        }

//        // n의 제곱근 구하기
//        double squareRoot = Math.sqrt(n);
//        // 중복제거위해 HashSet 사용
//        TreeSet<Integer> hashSet = new TreeSet<>();
//
//        for (int i = 1; i < squareRoot; i++) {
//            if (n % i == 0) {
//                hashSet.add(i);
//                hashSet.add(n / i);
//            }
//        }
//
//        List<Integer> result = new ArrayList<>(hashSet);
//        if (result.size() >= k) {
//            System.out.println(result.get(k - 1));
//        } else{
//            System.out.println(0);
//        }
    }
}
