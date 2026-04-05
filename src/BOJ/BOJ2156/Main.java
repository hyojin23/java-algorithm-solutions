package BOJ.BOJ2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int solution(int N, int[] wine) {
        if (N == 1) {
            return wine[1];
        }
        if (N == 2) {
            return wine[1] + wine[2];
        }
        int[] dp = new int[N + 1];
        dp[1] = wine[1];
        dp[2] = wine[1] + wine[2];
        for (int i = 3; i <= N; i++) {
            int max = Math.max(dp[i - 1], dp[i - 2] + wine[i]);
            dp[i] = Math.max(max, dp[i - 3] + wine[i] + wine[i - 1]);
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] wine = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(N, wine));
    }
}
