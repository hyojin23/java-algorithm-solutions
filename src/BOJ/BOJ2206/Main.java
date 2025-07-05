package BOJ.BOJ2206;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, breakWallCnt, dis;

    Point(int x, int y, int breakWallCnt, int dis) {
        this.x = x;
        this.y = y;
        this.breakWallCnt = breakWallCnt;
        this.dis = dis;
    }
}

public class Main {

    static int N, M;
    static int[][] board, dis;
    static boolean[][][] visited;

    public int BFS(int x, int y, int breakWallCnt, int dis) {

        Queue<Point> q = new LinkedList<>();
        visited[x][y][breakWallCnt] = true;
        q.offer(new Point(x, y, breakWallCnt, dis));
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dis;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny][cur.breakWallCnt]) {
                    if (board[nx][ny] == 0) {
                        visited[nx][ny][cur.breakWallCnt] = true;
                        q.offer(new Point(nx, ny, cur.breakWallCnt, cur.dis + 1));
                    }
                    else if (cur.breakWallCnt == 0) {
                        visited[nx][ny][cur.breakWallCnt] = true;
                        int newCnt = cur.breakWallCnt + 1;
                        q.offer(new Point(nx, ny, newCnt, cur.dis + 1));
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
        sc.nextLine();
        board = new int[N][M];
        dis = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - 48;
            }
        }
        System.out.println(T.BFS(0, 0, 0, 1));
    }
}
