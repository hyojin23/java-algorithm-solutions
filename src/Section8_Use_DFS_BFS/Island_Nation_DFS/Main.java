package Section8_Use_DFS_BFS.Island_Nation_DFS;

import java.util.Scanner;

public class Main {

    static int n;
    static int answer = 0;
    static int[][] ch, board;

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};


    public void DFS(int x, int y) {

        for (int k = 0; k < 8; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= 0 && nx <= n -1 && ny >= 0 && ny <= n - 1 && ch[nx][ny] == 0 && board[nx][ny] == 1) {
                ch[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ch[i][j] == 0 && board[i][j] == 1) {
                    answer++;
                    ch[i][j] = 1;
                    T.DFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
