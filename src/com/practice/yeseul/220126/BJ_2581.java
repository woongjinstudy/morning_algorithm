import java.util.Scanner;

public class No2581 {
    public static boolean isNotPrime[] = new boolean[10001]; //true: notPrime, false: Prime

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        int minPrime = -1, sum = 0;

        getPrime(N);

        for (int i = M; i <= N; i++) {
            if (!isNotPrime[i]) {
                sum += i;
                if (minPrime == -1) minPrime = i;
            }
        }
        if (minPrime == -1) System.out.println(-1);
        else System.out.println(sum + "\n" + minPrime);
    }

    private static void getPrime(int N) {
        isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}
