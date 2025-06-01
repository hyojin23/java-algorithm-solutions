package Recommended_Problems.DFS_BFS.BOJ17144;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, dust;

    Point(int x, int y, int dust) {
        this.x = x;
        this.y = y;
        this.dust = dust;
    }
}

public class Main {

    static int R, C, T, prTop, prBottom;
    static int[][] board;
    public int solution(Queue<Point> q) {

        BFS(q);

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                answer += board[i][j];
            }
        }
        return answer;
    }

    public void BFS(Queue<Point> q) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            if (L == T) {
                break;
            }
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                int newDust = p.dust / 5;
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != -1) {
                        board[p.x][p.y] -= newDust;
                        board[nx][ny] += newDust;
                    }
                }
            }
            L++;
            startPurifier();
            for (int k = 0; k < R; k++) {
                for (int l = 0; l < C; l++) {
                    if (board[k][l] > 0) {
                        q.offer(new Point(k, l, board[k][l]));
                    }
                }
            }
        }
    }

    public void startPurifier() {
        // 윗칸
        for (int i = prTop - 1; i >= 1; i--) {
            board[i][0] = board[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            board[0][i] = board[0][i + 1];
        }
        for (int i = 0; i < prTop; i++) {
            board[i][C - 1] = board[i + 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            board[prTop][i] = board[prTop][i - 1];
        }
        board[prTop][1] = 0;

        // 아랫칸
        for (int i = prBottom + 1; i < R - 1; i++) {
            board[i][0] = board[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            board[R - 1][i] = board[R - 1][i + 1];
        }
        for (int i = R - 1; i > prBottom; i--) {
            board[i][C - 1] = board[i - 1][C - 1];
        }
        for (int i = C - 1; i >= 2; i--) {
            board[prBottom][i] = board[prBottom][i - 1];
        }
        board[prBottom][1] = 0;
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        T = sc.nextInt();
        board = new int[R][C];
        Queue<Point> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > 0) {
                    q.offer(new Point(i, j, board[i][j]));
                }
                if (prTop == 0 && board[i][j] == -1) {
                    prTop = i;
                }
                if (prTop > 0 && board[i][j] == -1) {
                    prBottom = i;
                }
            }
        }
        System.out.println(main.solution(q));
    }
}
