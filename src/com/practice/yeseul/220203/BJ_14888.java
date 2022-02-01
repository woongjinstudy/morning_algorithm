import java.util.Scanner;

public class BJ_14888 {
    public static int N;
    public static int[] ops = new int[4];
    public static int[] numbers = new int[11];
    public static int maxNum = -1000000000;
    public static int minNum = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < N; i++) numbers[i] = sc.nextInt();

        for (int i = 0; i < 4; i++) ops[i] = sc.nextInt();

        getMaxMin(0, numbers[0]);
        System.out.println(maxNum);
        System.out.println(minNum);
    }

    private static void getMaxMin(int idx, int calNum) {
        if (idx == N - 1) {
            minNum = Math.min(minNum, calNum);
            maxNum = Math.max(maxNum, calNum);
            return;
        } else {
            int tmpCalNum = calNum;
            for (int i = 0; i < 4; i++) {
                if (ops[i] > 0) {
                    if (i == 0) { //+
                        calNum = tmpCalNum + numbers[idx+1];
                    } else if (i == 1) { //-
                        calNum = tmpCalNum - numbers[idx+1];
                    } else if (i == 2) { //*
                        calNum = tmpCalNum * numbers[idx+1];
                    } else { // ÷
                        calNum = tmpCalNum / numbers[idx+1];
                    }
                    ops[i]--;
                    getMaxMin(idx+1, calNum);
                    ops[i]++;
                }
            }
        }
    }
}
