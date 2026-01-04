package BOJ.BOJ16946;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, M;
    static int[][] board, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] wallCnt;

    public static void makeGroup(int x, int y, int grpNum) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        board[x][y] = grpNum;
        int cnt = 1;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0) {
                    board[nx][ny] = grpNum;
                    cnt++;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        wallCnt[grpNum] = cnt;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        answer = new int[N][M];
        wallCnt = new int[N * M + 2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        int grpNum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 0) {
                    grpNum++;
                    makeGroup(i, j, grpNum);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (board[i][j] == 1) {
                    HashSet<Integer> hs = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && board[ni][nj] != 1) {
                            hs.add(board[ni][nj]);
                        }
                    }
                    int sum = 1;
                    for (int nearByGrp : hs) {
                        sum += wallCnt[nearByGrp];
                    }
                    answer[i][j] = (sum % 10);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(answer[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
