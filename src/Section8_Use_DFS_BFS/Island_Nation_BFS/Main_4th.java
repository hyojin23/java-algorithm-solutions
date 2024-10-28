package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point_4th {

    int x, y;

    Point_4th(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_4th {

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[][] board;
    static int n;

    public void BFS(Point_4th point) {

        Queue<Point_4th> q = new LinkedList<>();
        q.offer(point);

        while (!q.isEmpty()) {
            int len = q.size();
            Point_4th p = q.poll();

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 8; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1 && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        q.offer(new Point_4th(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    T.BFS(new Point_4th(i, j));
                }
            }
        }
        System.out.println(answer);
    }
}
