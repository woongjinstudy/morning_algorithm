import java.util.Scanner;

public class No1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (getPrime(n)) cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean getPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
