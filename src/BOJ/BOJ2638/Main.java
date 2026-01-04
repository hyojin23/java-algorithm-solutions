package BOJ.BOJ2638;

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
}

public class Main {

    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M;
    static final int AIR = 0;       //공기
    static final int CHEESE = 1;    //치즈
    static final int OUT = 2;       //외부 공기
    static final int MELT = 9;      //녹을 대상

    public static void chkAir(int x, int y) {

        Queue<Point> q = new LinkedList<>();

        board[x][y] = OUT;
        q.offer(new Point(x, y));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == AIR) {
                    board[nx][ny] = OUT;  //외부 공기
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static int meltCheese() {

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == CHEESE) {
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && board[ni][nj] == OUT) {
                            cnt++;
                        }
                    }
                    if (cnt >= 2) {
                        board[i][j] = MELT;    //녹을 대상
                    }
                }
            }
        }

        int meltCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == MELT) {
                    board[i][j] = AIR;
                    meltCnt++;
                }
                if (board[i][j] == OUT) {
                    board[i][j] = AIR;
                }
            }
        }
        return meltCnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (true) {
            chkAir(0, 0);
            int meltCnt = meltCheese();
            if (meltCnt == 0) {
                break;
            }
            time++;
        }
        System.out.println(time);

    }
}
