package BOJ.BOJ1256;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static String solution(int N, int M, int K) {

        int[][] dp = new int[N + M + 1][N + M + 1];
        for (int n = 0; n <= N + M; n++) {
            dp[n][0] = dp[n][n] = 1;
            for (int r = 1; r < n; r++) {
                dp[n][r] = Math.min(1_000_000_001, dp[n - 1][r - 1] + dp[n - 1][r]);
            }
        }

        if (K > dp[N + M][N]) {
            return "-1";
        }

        StringBuilder sb = new StringBuilder();
        int n = N;
        int m = M;
        while (n > 0 && m > 0) {
            int count = dp[n + m - 1][n - 1];
            if (K <= count) {
                sb.append("a");
                n--;
            }
            else {
                sb.append("z");
                m--;
                K -= count;
            }
        }

        while (n > 0) {
            sb.append("a");
            n--;
        }

        while (m > 0) {
            sb.append("z");
            m--;
        }

        return sb.toString();
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(solution(N, M, K));
    }
}
