import java.util.Scanner;

public class No2609 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = getGcd(a, b);

        System.out.println(gcd);
        System.out.println(getLcm(a, b, gcd));
    }


    public static int getGcd(int a, int b) {
        if (b == 0) return a;
        return getGcd(b, a % b);
    }

    public static int getLcm(int a, int b, int gcd) {
        return a * b / gcd;
    }
}
