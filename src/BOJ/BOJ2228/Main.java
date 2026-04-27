package BOJ.BOJ2228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static int solution(int N, int M, int[] arr) {

        //dp[i][j] = i번째까지 고려해서 j개의 구간을 선택했을 때 최대값
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], -1_000_000_000);
        }

        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }

        //arr 배열 누적합
        int[] prefix = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i - 1][j];
                for (int k = 1; k <= i; k++) {
                   int sum = prefix[i] - prefix[k - 1];
                   if (k == 1) {
                       if (j == 1) {
                            dp[i][j] = Math.max(dp[i][j], sum);
                       }
                   }
                   else {
                       dp[i][j] = Math.max(dp[i][j], dp[k - 2][j - 1] + sum);
                   }
                }
            }
        }

        return dp[N][M];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solution(N, M, arr));
    }
}
