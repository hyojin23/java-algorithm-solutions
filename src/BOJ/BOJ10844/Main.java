package BOJ.BOJ10844;

import java.util.Scanner;

public class Main {

    static final int mod = 1000_000_000;
    public long solution(int N) {

        long[][] dp = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = dp[i - 1][1] % mod;
                }
                else if (j == 9) {
                    dp[i][9] = dp[i - 1][8] % mod;
                }
                else {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }
        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }
        return answer % mod;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        System.out.println(T.solution(N));
    }
}
