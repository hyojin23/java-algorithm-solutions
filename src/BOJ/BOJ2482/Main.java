package BOJ.BOJ2482;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static final int MOD = 1_000_000_003;

    public static int solution(int N, int K) {
        if (K == 0) return 1;
        if (K > N / 2) return 0;

        int[][] dp = new int[N + 1][K + 1];

        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if (j == 0) {
                    dp[i][j] = 1;
                }
                else if (j == 1) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
                }
            }
        }

        return (dp[N - 1][K] + dp[N - 3][K - 1]) % MOD;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        System.out.println(solution(N, K));
    }
}
