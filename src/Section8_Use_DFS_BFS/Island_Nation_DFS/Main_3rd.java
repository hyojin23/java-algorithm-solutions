package Section8_Use_DFS_BFS.Island_Nation_DFS;

import java.util.Scanner;

public class Main_3rd {

    static int[][] board;
    static int n;
    static int answer = 0;
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public void DFS(int i, int j) {

        for (int k = 0; k < 8; k++) {

            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    T.DFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
