package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n, answer;
    static int[][] board;
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && board[nx][ny] == 1) {
                        board[nx][ny] = 0;
                        q.offer(new Point(nx, ny));
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    answer++;
                    board[i][j] = 0;
                    T.BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
