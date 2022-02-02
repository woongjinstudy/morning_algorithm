package com.practice.salki;

import java.util.Scanner;
import java.util.Stack;

public class BJ_2504 {

    public static Stack<String> stack1 = new Stack<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(!fun(str)){
            System.out.println(0);
            return;
        }else{
            int tmpAns = 0;
            while(!stack1.empty()){
                String tmp = stack1.pop();
                if(!Character.isDigit(tmp.charAt(0))){
                    System.out.println(0);
                    return;
                }
                tmpAns += Integer.parseInt(tmp);
            }
            System.out.println(tmpAns);
        }
    }

    public static boolean fun(String str){
        for(int i=0; i<str.length(); i++){
            String tmp = String.valueOf(str.charAt(i));
            if("]".equals(tmp)||")".equals(tmp)){
                if(tmp.equals(")")){
                    if(stack1.empty()){
                        return false;
                    }
                    if(stack1.peek().equals("(")){
                        stack1.pop();
                        stack1.push("2");
                    }
                    else{
                        int sum = 0;
                        while(!stack1.empty()){
                            String tmp2 = stack1.pop();
                            if(tmp2.equals("[")||tmp2.equals("]")||tmp2.equals(")")){
                                return false;
                            }
                            if(tmp2.equals("(")){
                                stack1.push(String.valueOf(sum*2));
                                break;
                            }
                            sum += Integer.parseInt(tmp2);
                        }
                    }
                }
                else if(tmp.equals("]")){
                    if(stack1.empty()){
                        return false;
                    }
                    if(stack1.peek().equals("[")){
                        stack1.pop();
                        stack1.push("3");
                    }else{
                        int sum = 0;
                        while(!stack1.empty()){
                            String tmp2 = stack1.pop();
                            if(tmp2.equals("(")||tmp2.equals(")")||tmp2.equals("]")){
                                return false;
                            }
                            if(tmp2.equals("[")){
                                stack1.push(String.valueOf(sum*3));
                                break;
                            }
                            sum += Integer.parseInt(tmp2);
                        }
                    }
                }
            }else if("(".equals(tmp)||"[".equals(tmp)){
                stack1.push(tmp);
            }else {
                return false;
            }
        }
        return true;
    }


}

