package BOJ.BOJ4179;

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

    static int R, C;
    static char[][] board;
    static int[][] fireTime, jTime;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] fireVisited, jVisited;

    public void spreadFire(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !fireVisited[nx][ny] && board[nx][ny] != '#') {
                    fireVisited[nx][ny] = true;
                    q.offer(new Point(nx, ny));
                    fireTime[nx][ny] = fireTime[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public String jMove(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && !jVisited[nx][ny] && board[nx][ny] == '.') {
                    if (!fireVisited[nx][ny] || jTime[cur.x][cur.y] + 1 < fireTime[nx][ny]) {
                        jVisited[nx][ny] = true;
                        jTime[nx][ny] = jTime[cur.x][cur.y] + 1;
                        if (nx == 0 || nx == R - 1 || ny == 0 || ny == C - 1) {
                            return String.valueOf(jTime[nx][ny] + 1);
                        }
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];
        fireTime = new int[R][C];
        fireVisited = new boolean[R][C];
        jVisited = new boolean[R][C];
        jTime = new int[R][C];
        Queue<Point> fireQueue = new LinkedList<>();
        Queue<Point> jQueue = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'F') {
                    fireVisited[i][j] = true;
                    fireQueue.offer(new Point(i, j));
                }
                if (board[i][j] == 'J') {
                    jVisited[i][j] = true;
                    jQueue.offer(new Point(i, j));
                    if (i == 0 || i == R - 1 || j == 0 || j == C - 1) {
                        System.out.println(1);
                        return;
                    }
                }
            }
        }
        T.spreadFire(fireQueue);
        System.out.println(T.jMove(jQueue));
    }
}
