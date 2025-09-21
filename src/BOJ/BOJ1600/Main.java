package BOJ.BOJ1600;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, k;

    Point(int x, int y, int k) {
        this.x = x;
        this.y = y;
        this.k = k;
    }
}

public class Main {

    static int K, H, W;
    static int[][] board;
    static int[][][] dis;
    static boolean[][][] visited;

    public int BFS(int x, int y) {

        int[] dxh = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dyh = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        visited[x][y][0] = true;
        q.offer(new Point(x, y, 0));
        while(!q.isEmpty()) {
            Point current = q.poll();
            if (current.k < K) {
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + dxh[i];
                    int ny = current.y + dyh[i];
                    int nk = current.k + 1;
                    if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][nk] && board[nx][ny] == 0) {
                        visited[nx][ny][nk] = true;
                        dis[nx][ny][nk] = dis[current.x][current.y][current.k] + 1;
                        if (nx == H - 1 && ny == W - 1) {
                            return dis[nx][ny][nk];
                        }
                        q.offer(new Point(nx, ny, nk));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                int nk = current.k;
                if (nx >= 0 && nx < H && ny >= 0 && ny < W && !visited[nx][ny][nk] && board[nx][ny] == 0) {
                    visited[nx][ny][nk] = true;
                    dis[nx][ny][nk] = dis[current.x][current.y][current.k] + 1;
                    if (nx == H - 1 && ny == W - 1) {
                        return dis[nx][ny][nk];
                    }
                    q.offer(new Point(nx, ny, nk));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        K = sc.nextInt();
        W = sc.nextInt();
        H = sc.nextInt();
        board = new int[H][W];
        visited = new boolean[H][W][K + 1];
        dis = new int[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        if (W == 1 && H == 1) {
            System.out.println(0);
        }
        else {
            System.out.println(T.BFS(0, 0));
        }
    }
}
