package Recommended_Problems.DFS_BFS.BOJ14503;

import java.util.Scanner;

class Robot {

    int x, y, d;

    Robot (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.d = d;
    }
}

public class Main {

    static int N, M;
    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public boolean hasUncleanAround(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (board[nx][ny] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public int solution(int r, int c, int d) {

        Robot rb = new Robot(r, c, d);
        int cnt = 0;
        while (true) {
            if (board[rb.x][rb.y] == 0) {
                board[rb.x][rb.y] = 2;  // 2:청소된 상태
                cnt++;
            }
            if (hasUncleanAround(rb.x, rb.y)) {
                turnLeft(rb);
                int nx = rb.x + dx[rb.d];
                int ny = rb.y + dy[rb.d];
                if (board[nx][ny] == 0) {
                    rb.x = nx;
                    rb.y = ny;
                }
            }
            else {
                int rd = findReverseDirection(rb.d);
                int nx = rb.x + dx[rd];
                int ny = rb.y + dy[rd];
                if (board[nx][ny] == 1) {
                    break;
                }
                else {
                    rb.x = nx;
                    rb.y = ny;
                }
            }
        }
        return cnt;
    }

    public int findReverseDirection(int d) {
        if (d == 0) {
            return 2;
        }
        else if (d == 1) {
            return 3;
        }
        else if (d == 2) {
            return 0;
        }
        else if (d == 3) {
            return 1;
        }
        return -1;
    }

    public void turnLeft(Robot rb) {
        if (rb.d == 0) {
            rb.d = 3;
        }
        else if (rb.d == 1) {
            rb.d = 0;
        }
        else if (rb.d == 2) {
            rb.d = 1;
        }
        else if (rb.d == 3) {
            rb.d = 2;
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(r, c, d));
    }
}
