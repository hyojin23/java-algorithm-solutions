package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Island {
    int x, y;
    Island(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, answer = 0;
    static int[][] board;
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    public void solution() {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i, j);
                }
            }
        }
    }

    public void BFS(int x, int y) {

        Queue<Island> queue = new LinkedList<>();
        queue.offer(new Island(x, y));

        while(!queue.isEmpty()) {

            Island land = queue.poll();
            for (int i = 0; i < 8; i++) {
                int nx = land.x + dx[i];
                int ny = land.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    queue.offer(new Island(nx, ny));
                }
            }
        }
        answer++;
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
        T.solution();
        System.out.println(answer);
    }
}
