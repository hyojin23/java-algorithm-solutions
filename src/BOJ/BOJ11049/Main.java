package BOJ.BOJ11049;

import java.util.Scanner;

public class Main {

    public int solution(int N, int[][] matrix) {

        int[][] dp = new int[N][N];

        for (int len = 2; len <= N; len++) {
            for (int i = 0; i + len - 1 < N; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + matrix[i][0] * matrix[k][1] * matrix[j][1];
                    dp[i][j] = Math.min(cost, dp[i][j]);
                }
            }
        }
        return dp[0][N - 1];
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] matrix = new int[N][2];
        for (int i = 0; i < N; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        System.out.println(main.solution(N, matrix));
    }
}
