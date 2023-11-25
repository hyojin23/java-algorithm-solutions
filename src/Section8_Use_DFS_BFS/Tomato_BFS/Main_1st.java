package Section8_Use_DFS_BFS.Tomato_BFS;

import java.util.*;

class Tomato_1st {
    int x, y;

    public Tomato_1st(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_1st {

    static int m, n;
    static int[][] board, dis;
    static Queue<Tomato_1st> queue = new LinkedList<>();

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public void BFS() {

        while (!queue.isEmpty()) {

            Tomato_1st t = queue.poll();

            for (int i = 0; i < 4; i++) {

                int nx = t.x + dx[i];
                int ny = t.y + dy[i];

                if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= m - 1 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.offer(new Tomato_1st(nx, ny));
                    dis[nx][ny] = dis[t.x][t.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        board = new int[n][m];
        dis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 1) {
                    queue.offer(new Tomato_1st(i, j));
                }
            }
        }
        T.BFS();

        boolean isAllRipen = true;
        int answer = Integer.MIN_VALUE;

        for (int[] arr : board) {
            for (int x : arr) {
                if (x == 0) isAllRipen = false;
            }
        }

        if (isAllRipen) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }
    }
}
