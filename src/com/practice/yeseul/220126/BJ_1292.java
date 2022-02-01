import java.util.Scanner;

public class No1292 {
    public static int arr[] = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), B = sc.nextInt();
        int sum = 0;
        getSequence(A, B);

        for (int i = A; i <= B; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        sc.close();
    }

    public static void getSequence(int A, int B) {
        int cnt = 1;
        for (int i = 1; i <= B; i++) {
            for (int j = 0; j < i; j++) {
                if (cnt > B) return;
                arr[cnt++] = i;
            }
        }
    }

}
