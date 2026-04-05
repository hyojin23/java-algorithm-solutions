package BOJ.BOJ2573;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Point_1st {

    int x, y, h;

    Point_1st(int x, int y, int h) {
        this.x = x;
        this.y = y;
        this.h = h;
    }
}

public class Main_1st {

    static int N, M;
    static int[][] board, ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(Queue<Point_1st> q) {

        int L = 0;
        while (!q.isEmpty()) {
            ch = new int[N][M];
            if (isDivided(board)) {
                return L;
            }
            int len = q.size();
            List<Point_1st> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                Point_1st cur = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (board[nx][ny] == 0) {
                        cur.h--;
                    }
                }
                if (cur.h > 0) {
                    q.offer(cur);
                    list.add(new Point_1st(cur.x, cur.y, cur.h));
                }
                else {
                    list.add(new Point_1st(cur.x, cur.y, 0));
                }
            }
            for (Point_1st p : list) {
                board[p.x][p.y] = p.h;
            }
            L++;
        }
        return 0;
    }

    public boolean isDivided(int[][] board) {

        int cnt = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0 && ch[i][j] == 0) {
                    ch[i][j] = 1;
                    DFS(i, j);
                    cnt++;
                }
                if (cnt >= 2) {
                    return true;
                }
            }
        }
        return false;
    }

    public void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] > 0 && ch[nx][ny] == 0) {
                ch[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }


    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        ch = new int[N][M];
        Queue<Point_1st> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > 0) {
                    q.add(new Point_1st(i, j, board[i][j]));
                }
            }
        }
        System.out.println(T.solution(q));
    }
}
