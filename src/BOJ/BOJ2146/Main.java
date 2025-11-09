package BOJ.BOJ2146;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static void labelIsland(int x, int y, int id) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        board[x][y] = id;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && board[nx][ny] == 1) {
                        board[nx][ny] = id;
                        visited[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
    }

    static int BFS(int id) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visitedBFS = new boolean[N][N];
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == id) {
                    q.offer(new Point(i, j));
                    visitedBFS[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (visitedBFS[nx][ny]) {
                        continue;
                    }
                    if (board[nx][ny] > 0 && board[nx][ny] != id) {
                        return dist[cur.x][cur.y];
                    }

                    if (board[nx][ny] == 0) {
                        dist[nx][ny] = dist[cur.x][cur.y] + 1;
                        visitedBFS[nx][ny] = true;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited = new boolean[N][N];
        int islandId = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    labelIsland(i, j, islandId);
                    islandId++;
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int id = 2; id < islandId; id++) {
            answer = Math.min(answer, BFS(id));
        }
        System.out.println(answer);
    }
}
