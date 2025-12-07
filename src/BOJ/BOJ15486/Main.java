package BOJ.BOJ15486;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public int solution(int N, int[] dp, int[] T, int[] P) {

        for (int day = N - 1; day >= 0; day--) {
            if (day + T[day] > N) {
                dp[day] = dp[day + 1];
                continue;
            }
            dp[day] = Math.max(dp[day + 1], dp[day + T[day]] + P[day]);
        }
        return dp[0];
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int[] T = new int[N];
        int[] P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(N, dp, T, P));
    }
}
