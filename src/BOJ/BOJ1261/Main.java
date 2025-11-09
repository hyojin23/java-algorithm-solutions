package BOJ.BOJ1261;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

class Point {

    int x, y;

    Point(int x, int y) {

        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] dist;
    static int M, N;
    public int bfs(int x, int y, int[][] board) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<Point> dq = new ArrayDeque<>();
        dq.add(new Point(x, y));
        dist[x][y] = 0;

        while (!dq.isEmpty()) {
            Point cur = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nextCost = dist[cur.x][cur.y] + board[nx][ny];
                    if (nextCost < dist[nx][ny]) {
                        dist[nx][ny] = nextCost;
                        if (board[nx][ny] == 0) {
                            dq.addFirst(new Point(nx, ny));
                        }
                        else {
                            dq.addLast(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        return dist[N - 1][M - 1];
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(main.bfs(0, 0, board));
    }
}
