package BOJ.BOJ14501;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int[] T, int[] P) {

        int[] dp = new int[N + 6];

        for (int i = N; i >= 1; i--) {
            if (i + T[i] <= N + 1) {
                dp[i] = Math.max(dp[i + 1], dp[i + T[i]] + P[i]);
            }
            else {
                dp[i] = dp[i + 1];
            }
        }

        return dp[1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, T, P));
    }
}
