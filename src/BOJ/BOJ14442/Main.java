package BOJ.BOJ14442;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Point {

    int x, y, k, d;

    Point (int x, int y, int k, int d) {
        this.x = x;
        this.y = y;
        this.k = k;
        this.d = d;
    }
}

public class Main {

    static int N, M, K;
    static int[][] board, visited;

    public static int bfs(int x, int y) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, 0, 1));
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], K + 1);
        }
        visited[0][0] = 0;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.d;
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    int nk = cur.k;
                    if (board[nx][ny] == 1) {
                        nk++;
                    }
                    if (nk > K) continue;
                    if (nk >= visited[nx][ny]) continue;
                    visited[nx][ny] = nk;
                    q.offer(new Point(nx, ny, nk, cur.d + 1));
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
        K = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }
}
