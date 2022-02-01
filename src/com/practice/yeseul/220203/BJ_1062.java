import java.util.Scanner;

public class BJ_1062 {
    public static int N;
    public static int K;
    public static int maxWordCnt = 0;
    public static String[] words;
    public static boolean[] visit = new boolean[26];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        visit[(int) 'a' - 97] = true;
        visit[(int) 'n' - 97] = true;
        visit[(int) 't' - 97] = true;
        visit[(int) 'i' - 97] = true;
        visit[(int) 'c' - 97] = true;

        N = sc.nextInt();
        K = sc.nextInt();
        words = new String[N];

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            words[i] = sc.nextLine();
        }

        getAnswer(0, 0);
        System.out.println(maxWordCnt);
    }

    private static void getAnswer(int alphaIdx, int charCnt) {
        if (charCnt == K - 5) {
            int wordCnt = 0;
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                boolean readable = true;
                for (int j = 4; j < word.length() - 4; j++) {
                    if (!visit[(int) word.charAt(j) - 97]) {
                        char c = word.charAt(j);
                        readable = false;
                        break;
                    }
                }
                if (readable) wordCnt++;
            }
            maxWordCnt = Math.max(maxWordCnt, wordCnt);
            return;
        }

        for (int i = alphaIdx; i < 26; i++) {
            if (!visit[i]) {
                visit[i] = true;
                getAnswer(i + 1, charCnt + 1);
                visit[i] = false;
            }
        }
    }
}
