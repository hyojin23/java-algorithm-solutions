package Recommended_Problems.DFS_BFS.BOJ1726;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, dir, orders;

    Point(int x, int y, int dir, int orders) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.orders = orders;
    }
}

public class Main {

    static int M, N;
    static int[][] board;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 0, 1, -1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int[][] dirOdrCnt = {{0, 0, 0, 0, 0}
                              , {0, 0, 2, 1, 1}     // 동
                              , {0, 2, 0, 1, 1}     // 서
                              , {0, 1, 1, 0, 2}     // 남
                              , {0, 1, 1, 2, 0}};   // 북
    public int BFS(int Sx, int Sy, int Sd, int Ex, int Ey, int Ed) {

        Queue<Point> q = new LinkedList<>();
        visited[Sx][Sy][Sd] = true;
        q.offer(new Point(Sx, Sy, Sd, 0));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == Ex && cur.y == Ey && cur.dir == Ed) {
                return cur.orders;
            }

            for (int k = 1; k <= 3; k++) {  // 이동
                int nx = cur.x + dx[cur.dir] * k;
                int ny = cur.y + dy[cur.dir] * k;
                if (nx < 1 || nx > M || ny < 1 || ny > N) {
                    break;
                }
                if (board[nx][ny] == 1) {
                    break;
                }

                if (board[nx][ny] == 0) {
                    if (!visited[nx][ny][cur.dir]) {
                        visited[nx][ny][cur.dir] = true;
                        q.offer(new Point(nx, ny, cur.dir, cur.orders + 1));
                    }
                }
            }

            for (int i = 1; i <= 4; i++) {  // 방향 전환 (1:동, 2:서, 3:남, 4:북)
                if (i == cur.dir) {
                    continue;
                }
                int no = cur.orders + dirOdrCnt[cur.dir][i]; // 방향 전환시 명령 증가
                if (!visited[cur.x][cur.y][i]) {
                    visited[cur.x][cur.y][i] = true;
                    q.offer(new Point(cur.x, cur.y, i, no));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        board = new int[M + 1][N + 1];
        visited = new boolean[M + 1][N + 1][5];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int Sx = sc.nextInt();
        int Sy = sc.nextInt();
        int Sd = sc.nextInt();
        int Ex = sc.nextInt();
        int Ey = sc.nextInt();
        int Ed = sc.nextInt();
        System.out.println(T.BFS(Sx, Sy, Sd, Ex, Ey, Ed));
    }
}
