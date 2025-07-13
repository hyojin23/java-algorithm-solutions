package BOJ.BOJ7562;

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

    static int[][] board;
    static boolean[][] visited;
    static int n, m;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public int BFS(int startX, int startY, int endX, int endY) {

        int[][] cnt = new int[m][m];
        Queue<Point> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.offer(new Point(startX, startY));
        while(!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < m && !visited[nx][ny]) {
                    cnt[nx][ny] = cnt[cur.x][cur.y] + 1;
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return cnt[endX][endY];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            board = new int[m][m];
            visited = new boolean[m][m];
            int startX = sc.nextInt();
            int startY = sc.nextInt();
            int endX = sc.nextInt();
            int endY = sc.nextInt();
            System.out.println(T.BFS(startX, startY, endX, endY));
        }
    }
}
