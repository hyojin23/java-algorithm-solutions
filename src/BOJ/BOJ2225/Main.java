package BOJ.BOJ2225;

import java.util.Scanner;

public class Main {

    static final int MOD = 1000_000_000;

    public int solution(int N, int K) {

        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 1 || j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
                }
            }
        }
        return dp[K][N];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.solution(N, K));
    }
}
