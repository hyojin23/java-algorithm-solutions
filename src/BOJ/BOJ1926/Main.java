package BOJ.BOJ1926;

import java.util.Scanner;

public class Main {

    static int n, m, area;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public void DFS(int x, int y) {

        board[x][y] = 0;
        area++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1) {
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int cnt = 0;
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) {
                    cnt++;
                    area = 0;
                    T.DFS(i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        System.out.println(cnt);
        System.out.println(maxArea);
    }
}
