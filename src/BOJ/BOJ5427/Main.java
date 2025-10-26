package BOJ.BOJ5427;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Point {

    int x, y, time;

    Point(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int w, h;
    static boolean[][] fVisited, sVisited;
    static int[][] dis;

    public String BFS(char[][] board, Queue<Point> fq, Queue<Point> sq) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        while (!fq.isEmpty()) {
            Point cur = fq.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && (board[nx][ny] == '.' || board[nx][ny] == '@')) {
                    if (!fVisited[nx][ny]) {
                        fVisited[nx][ny] = true;
                        dis[nx][ny] = dis[cur.x][cur.y] + 1;
                        fq.offer(new Point(nx, ny, cur.time + 1));
                    }
                }
            }
        }

        while (!sq.isEmpty()) {
            Point cur = sq.poll();
            if (cur.x == 0 || cur.x == h - 1 || cur.y == 0 || cur.y == w - 1) {
                return String.valueOf(cur.time + 1);
            }
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] == '.' && !sVisited[nx][ny]) {
                    if (dis[nx][ny] == -1 || dis[nx][ny] > cur.time + 1) {
                        sVisited[nx][ny] = true;
                        sq.offer(new Point(nx, ny, cur.time + 1));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }


    public static void main(String[] args) throws IOException {

        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int c = 0; c < T; c++) {
            Queue<Point> fq = new LinkedList<>();
            Queue<Point> sq = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            char[][] board = new char[h][w];
            fVisited = new boolean[h][w];
            sVisited = new boolean[h][w];
            dis = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(dis[i], -1);
            }
            for (int i = 0; i < h; i++) {
                String str = br.readLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == '*') {
                        fq.offer(new Point(i, j, 0));
                        dis[i][j] = 0;
                    }
                    if (board[i][j] == '@') {
                        sq.offer(new Point(i, j, 0));
                    }
                }
            }
            System.out.println(main.BFS(board, fq, sq));
        }
    }
}
