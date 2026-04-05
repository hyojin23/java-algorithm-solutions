package BOJ.BOJ2234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] board, roomIds;
    static int[] dx = {0, -1, 0, 1}; //서, 북, 동, 남
    static int[] dy = {-1, 0, 1, 0};
    static List<Integer> roomCount;

    public static void bfs(int x, int y, boolean[][] visited, int id) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;
        roomIds[x][y] = id;
        int cnt = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (!visited[nx][ny] && (board[cur.x][cur.y] & (1 << i)) == 0) {
                        visited[nx][ny] = true;
                        cnt++;
                        roomIds[nx][ny] = id;
                        q.offer(new Point(nx, ny));
                    }
                }
            }
        }
        roomCount.add(cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[M][N];
        roomIds = new int[M][N];
        roomCount = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean[][] visited = new boolean[M][N];
        int id = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, visited, id);
                    id++;
                }
            }
        }
        int max = roomCount.stream().mapToInt(Integer::intValue).max().getAsInt();
        int noWallMax = max;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) {
                        continue;
                    }
                    boolean isWall = (board[i][j] & (1 << k)) != 0;
                    if (isWall && roomIds[i][j] != roomIds[nx][ny]) {
                        noWallMax = Math.max(noWallMax, roomCount.get(roomIds[i][j] - 1) + roomCount.get(roomIds[nx][ny] - 1));
                    }
                }
            }
        }
        System.out.println(roomCount.size());
        System.out.println(max);
        System.out.println(noWallMax);
    }
}
