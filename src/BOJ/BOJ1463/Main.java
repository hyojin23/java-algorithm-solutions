package BOJ.BOJ1463;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static int solution(int N) {
        int[] dp = new int[N + 1];
        Arrays.fill(dp, 1_000_000);
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }
        return dp[N];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(solution(N));
    }
}
