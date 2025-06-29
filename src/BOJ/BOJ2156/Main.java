package BOJ.BOJ2156;

import java.util.Scanner;

public class Main {

    public int solution(int n, int[] wines) {

        int[] dp = new int[n + 1];
        dp[1] = wines[1];
        if (n >= 2) {
            dp[2] = wines[1] + wines[2];
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(wines[i] + dp[i - 2], wines[i] + wines[i - 1] + dp[i - 3]));
        }
        return dp[n];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] wines = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            wines[i] = sc.nextInt();
        }
        System.out.println(T.solution(n, wines));
    }
}
