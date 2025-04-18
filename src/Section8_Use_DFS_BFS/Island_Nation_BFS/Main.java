package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Island {

    int x, y;

    Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;
    static int n;

    public void BFS(int x, int y) {
        Queue<Island> q = new LinkedList<>();
        q.offer(new Island(x, y));

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Island land = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = land.x + dx[j];
                    int ny = land.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        q.offer(new Island(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    answer++;
                    T.BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
