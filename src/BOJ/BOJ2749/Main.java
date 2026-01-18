package BOJ.BOJ2749;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int solution(long N) {

        int P = 1_500_000;
        int M = 1_000_000;
        int period = (int)(N % P);

        if (period == 0) return 0;
        if (period == 1) return 1;

        int[] dp = new int[period + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= period; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % M;
        }
        return dp[period];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        System.out.println(solution(N));
    }
}
