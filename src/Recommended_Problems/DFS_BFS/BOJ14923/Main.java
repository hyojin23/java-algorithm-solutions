package Recommended_Problems.DFS_BFS.BOJ14923;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, dis, cnt;

    Point(int x, int y, int dis, int cnt) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.cnt = cnt;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static boolean[][][] visited;

    public int BFS(int Hx, int Hy, int Ex, int Ey) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        visited[Hx][Hy][0] = true;
        q.offer(new Point(Hx, Hy, 0, 0));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == Ex && cur.y == Ey) {
                return cur.dis;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M) {
                    if (board[nx][ny] == 0) {
                        if (!visited[nx][ny][cur.cnt]) {
                            visited[nx][ny][cur.cnt] = true;
                            q.offer(new Point(nx, ny, cur.dis + 1, cur.cnt));
                        }
                    }
                    else {
                        if (cur.cnt == 0 && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.offer(new Point(nx, ny, cur.dis + 1, 1));
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int Hx = sc.nextInt();
        int Hy = sc.nextInt();
        int Ex = sc.nextInt();
        int Ey = sc.nextInt();
        board = new int[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1][2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        System.out.println(T.BFS(Hx, Hy, Ex, Ey));
    }
}
