package BOJ.BOJ11066;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public int solution(int K, int[] arr) {

        int INF = 1000_000_000;
        int[] sum = new int[K + 1];
        int[][] dp = new int[K + 1][K + 1];

        for (int i = 1; i <= K; i++) {
            dp[i][i] = 0;
        }

        for (int i = 1; i <= K; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }

        for (int len = 2; len <= K; len++) {
            for (int i = 1; i + len - 1 <= K; i++) {
                int j = i + len - 1;

                dp[i][j] = INF;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + (sum[j] - sum[i - 1]));
                }
            }
        }

        return dp[1][K];
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int[] arr = new int[K];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println(main.solution(K, arr));
        }
    }
}
