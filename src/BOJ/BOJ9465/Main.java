package BOJ.BOJ9465;

import java.util.Scanner;


public class Main {

    public void solution(int n, int[][] board, int[][] dp) {

        dp[0][1] = board[0][1];
        dp[1][1] = board[1][1];
        for (int i = 2; i <= n; i++) {
            dp[0][i] = board[0][i] + Math.max(dp[1][i - 1], dp[1][i - 2]);
            dp[1][i] = board[1][i] + Math.max(dp[0][i - 1], dp[0][i - 2]);
        }
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] board = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];
            for (int j = 0; j < 2; j++) {
                for (int k = 1; k <= n; k++) {
                    board[j][k] = sc.nextInt();
                }
            }
            main.solution(n, board, dp);
            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }
        System.out.println(sb);
    }
}
