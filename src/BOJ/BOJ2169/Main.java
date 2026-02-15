package BOJ.BOJ2169;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {


    public static int solution(int N, int M, int[][] board) {

        int[][] dp = new int[N][M];
        dp[0][0] = board[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];

            for (int j = 0; j < M; j++) {
                if (j == 0) {
                    left[j] = dp[i - 1][j] + board[i][j];
                }
                else {
                    left[j] = Math.max(dp[i - 1][j], left[j - 1]) + board[i][j];
                }
            }

            for (int j = M - 1; j >= 0; j--) {
                if (j == M - 1) {
                    right[j] = dp[i - 1][j] + board[i][j];
                }
                else {
                    right[j] = Math.max(dp[i - 1][j], right[j + 1]) + board[i][j];
                }
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        return dp[N - 1][M - 1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(N, M, board));
    }
}
