import java.util.Arrays;
import java.util.Scanner;

public class BJ_14719 {
    public static int H, W;
    public static int[] heights = new int[500];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        H = sc.nextInt();
        W = sc.nextInt();
        for (int i = 0; i < W; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(getAnswer());
    }

    private static int getAnswer() {
        int sum = 0;

        for (int i = 1; i < W - 1; i++) {
            int leftMaxHeight = -1;
            int rightMaxHeight = -1;

            for (int left = 0; left < i; left++) {
                leftMaxHeight = Math.max(leftMaxHeight, heights[left]);
            }
            for (int right = i + 1; right < W; right++) {
                rightMaxHeight = Math.max(rightMaxHeight, heights[right]);
            }
            if (heights[i] < Math.min(leftMaxHeight, rightMaxHeight)) {
                sum += Math.min(leftMaxHeight, rightMaxHeight) - heights[i];
            }
        }

        return sum;
    }
}
