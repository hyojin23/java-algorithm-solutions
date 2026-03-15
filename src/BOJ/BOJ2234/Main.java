package BOJ.BOJ2234;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point (int x, int y) {
        this.x = x;
        this.y  = y;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static boolean[][] visited;

    public static List<Integer> solution() {

        List<Integer> answer = new ArrayList<>();
        visited = new boolean[M][N];
        int cnt = 0;
        int max = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    cnt++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        answer.add(cnt);
        answer.add(max);

        return answer;
    }

    public static int bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        int max = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int val = board[cur.x][cur.y];

            for (int i = 0; i < 4; i++) {
                if (val % 2 == 0) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        max++;
                        q.offer(new Point(nx, ny));
                    }
                }
                val = val / 2;
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int x : solution()) {
            System.out.println(x);
        }
    }
}
