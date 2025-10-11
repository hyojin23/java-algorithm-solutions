package BOJ.BOJ1937;

import java.util.Scanner;

public class Main {

    static int N;
    static int[][] board, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int DFS(int x, int y) {

        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] > board[x][y]) {
                dp[x][y] = Math.max(dp[x][y], DFS(nx, ny) + 1);
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];
        dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, T.DFS(i, j));
            }
        }
        System.out.println(answer);
    }
}
