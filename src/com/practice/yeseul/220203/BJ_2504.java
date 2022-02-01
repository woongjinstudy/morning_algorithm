import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class BJ_2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(getAnswer(input));
    }

    private static int getAnswer(String input) {
        Stack<Character> stack = new Stack<>();
        boolean isWrongInput = false;
        int answer = 0;
        int cnt = 1;
        for (int i = 0; i < input.length(); i++) {
            char now = input.charAt(i);
            if (now == '(') {
                stack.push(now);
                cnt *= 2;
            } else if (now == '[') {
                stack.push(now);
                cnt *= 3;
            } else {
                if (now == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        isWrongInput = true;
                        break;
                    } else if (input.charAt(i - 1) == '(') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 2;
                } else if (now == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        isWrongInput = true;
                        break;
                    } else if (input.charAt(i - 1) == '[') {
                        answer += cnt;
                    }
                    stack.pop();
                    cnt /= 3;
                } else {
                    isWrongInput = true;
                    break;
                }
            }
        }
        if (isWrongInput || !stack.isEmpty()) {
            return 0;
        } else {
            return answer;
        }
    }
}