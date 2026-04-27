package BOJ.BOJ2206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, dis;
    boolean isWallBroken;

    Point(int x, int y, int dis, boolean isWallBroken) {
        this.x = x;
        this.y = y;
        this.dis = dis;
        this.isWallBroken = isWallBroken;
    }
}

public class Main {

    static int[][] board;
    static int N, M;

    public static int bfs(int x, int y) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 1, false));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dis;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (cur.isWallBroken && board[nx][ny] == 1) {
                    continue;
                }

                if (board[nx][ny] == 0) {
                    int wall = cur.isWallBroken ? 1 : 0;
                    if (!visited[nx][ny][wall]) {
                        visited[nx][ny][wall] = true;
                        q.offer(new Point(nx, ny, cur.dis + 1, cur.isWallBroken));
                    }
                }
                else if (!cur.isWallBroken && board[nx][ny] == 1 && !visited[nx][ny][1]){
                    visited[nx][ny][1] = true;
                    q.offer(new Point(nx, ny, cur.dis + 1, true));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0, 0));
    }
}
