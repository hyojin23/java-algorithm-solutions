package BOJ.BOJ2636;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}

public class Main {

    static int N, M;
    static int[][] board, visited;
    static int visitId = 1;

    public static int meltCheese() {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        Queue<Point> meltQ = new LinkedList<>();
        q.offer(new Point(0, 0));
        visited[0][0] = visitId;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && visited[nx][ny] != visitId) {
                    visited[nx][ny] = visitId;
                    if (board[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                    }
                    else {
                        meltQ.offer(new Point(nx, ny));
                    }
                }
            }
        }

        //치즈 녹이기
        for (Point p : meltQ) {
            board[p.x][p.y] = 0;
        }

        visitId++;

        return meltQ.size();
    }



    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int lastMelt = 0;
        while (true) {
            int melted = meltCheese();
            if (melted == 0) {
                break;
            }
            lastMelt = melted;
            time++;
        }

        System.out.println(time);
        System.out.println(lastMelt);
    }
}
