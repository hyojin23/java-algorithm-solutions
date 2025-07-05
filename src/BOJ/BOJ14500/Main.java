package BOJ.BOJ14500;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int N, M, max;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static List<int[]> list;
    public void DFS(int L, int x, int y, int sum) {
        if (L == 4) {
            max = Math.max(max, sum);
        }
        else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                    if (L == 2) {
                        visited[nx][ny] = true;
                        DFS(L + 1, x, y, sum + board[nx][ny]);
                        visited[nx][ny] = false;
                    }
                    visited[nx][ny] = true;
                    DFS(L + 1, nx, ny, sum + board[nx][ny]);
                    visited[nx][ny] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                list = new ArrayList<>();
                list.add(new int[]{i, j});
                visited[i][j] = true;
                T.DFS(1, i, j, board[i][j]);
                visited[i][j] = false;
            }
        }
        System.out.println(max);
    }
}
