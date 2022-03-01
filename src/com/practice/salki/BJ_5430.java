//package com.practice.salki;
//
//import java.io.IOException;
//import java.util.Deque;
//import java.util.LinkedList;
//import java.util.Scanner;
//
//public class BJ_5430 {
//
//    public static void main(String[] args) throws IOException {
//        Scanner sc = new Scanner(System.in);
//
//        int t = sc.nextInt();
//        for(int i=0; i<t; i++)
//        {
//            String p = sc.next();
//            int n = sc.nextInt();
//            String arr = sc.next();
//            try{
//                func(p,n,arr);
//            }catch (Exception e) {
//                System.out.println("error");
//            }
//        }
//
//    }
//
//    public static void func(String p, int n, String arr) throws Exception{
//        arr = arr.substring(1, arr.length()-1);
//        String[] tmpArr = arr.split(",");
//        Deque<Integer> q = new LinkedList<>();
//        if(!"".equals(arr)) {
//            for (int i = 0; i < tmpArr.length; i++) {
//                q.add(Integer.parseInt(tmpArr[i]));
//            }
//        }
//        boolean front = true;
//        for(int i=0; i<p.length(); i++){
//            char tmpChar = p.charAt(i);
//            switch (tmpChar){
//                case 'R':
//                    front = !front;
//                    break;
//                case 'D':
//                    if(front) q.removeFirst();
//                    else q.removeLast();
//                    break;
//            }
//        }
//        System.out.print("[");
//        while(!q.isEmpty()){
//         if(front){
//             if(q.size()==1) {
//                 System.out.print(q.pollFirst());
//                 continue;
//             }
//             else System.out.print(q.pollFirst()+",");
//         }else{
//             if(q.size()==1) {
//                 System.out.print(q.pollLast());
//                 continue;
//             }
//             else System.out.print(q.pollLast()+",");
//         }
//        }
//        System.out.println("]");
//    }
//
//
//
//
//
//}
//
