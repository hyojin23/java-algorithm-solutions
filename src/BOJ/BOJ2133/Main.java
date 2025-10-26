package BOJ.BOJ2133;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public int solution(int N) {

        int[] dp = new int[31];
        dp[0] = 1;
        for (int i = 2; i <= 30; i += 2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                dp[i] += dp[j] * 2;
            }
        }
        return dp[N];
    }


    public static void main(String[] args) throws IOException {

        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(T.solution(N));
    }
}
