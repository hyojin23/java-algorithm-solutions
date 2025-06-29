package BOJ.BOJ1520;

import java.util.Scanner;

public class Main {

    static int M, N, cnt;
    static int[][] board, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int DFS(int x, int y) {

        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[x][y] != -1) {
            return dp[x][y];
        }
        else {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] < board[x][y]) {
                    dp[x][y] += DFS(nx, ny);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[M][N];
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }
        T.DFS(0, 0);
        System.out.println(dp[0][0]);
    }
}
