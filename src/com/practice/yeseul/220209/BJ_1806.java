import java.util.Scanner;

public class BJ_1806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(getAnswer(N, S, arr));
    }

    private static int getAnswer(int N, int S, int[] arr) {
        int point1 = 0, point2 = 0, sum = arr[0], minLength = 100000;
        while (point1 < N && point2 < N) {
            if (sum == S) {
                minLength = Math.min(minLength, point2 - point1 + 1);
                sum -= arr[point1++];

            }
            if (sum < S) {
                point2++;
                if (point2 < N) sum += arr[point2];
            } else {
                minLength = Math.min(minLength, point2 - point1 + 1);
                sum -= arr[point1++];

            }
        }
        return minLength != 100000 ? minLength : 0;
    }
}