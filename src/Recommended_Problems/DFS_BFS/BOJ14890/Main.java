package Recommended_Problems.DFS_BFS.BOJ14890;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;
    static int N, L, answer;
    static boolean[][] hasUsed;

    public void goHorizontally(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        hasUsed = new boolean[N][N];
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.y == N - 1) {
                answer++;
                break;
            }
            if (Math.abs(board[cur.x][cur.y] - board[cur.x][cur.y + 1]) > 1) {
                break;
            }
            if (board[cur.x][cur.y] == board[cur.x][cur.y + 1]) {
                q.offer(new Point(cur.x, cur.y + 1));
            }
            else if (board[cur.x][cur.y] > board[cur.x][cur.y + 1]) {
                if (canPlaceRamp(cur.x, cur.y + 1, "ho", "down")) {
                    q.offer(new Point(cur.x, cur.y + 1));
                }
            }
            else {
                if (canPlaceRamp(cur.x, cur.y, "ho", "up")) {
                    q.offer(new Point(cur.x, cur.y + 1));
                }
            }
        }
    }

    public void goVerticallly(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        hasUsed = new boolean[N][N];
        while (!q.isEmpty()) {
            Point cur = q.poll();
            if (cur.x == N - 1) {
                answer++;
                break;
            }
            if (Math.abs(board[cur.x][cur.y] - board[cur.x + 1][cur.y]) > 1) {
                break;
            }
            if (board[cur.x][cur.y] == board[cur.x + 1][cur.y]) {
                q.offer(new Point(cur.x + 1, cur.y));
            }
            else if (board[cur.x][cur.y] > board[cur.x + 1][cur.y]) {
                if (canPlaceRamp(cur.x + 1, cur.y, "ve", "down")) {
                    q.offer(new Point(cur.x + 1, cur.y));
                }
            }
            else {
                if (canPlaceRamp(cur.x, cur.y, "ve", "up")) {
                    q.offer(new Point(cur.x + 1, cur.y));
                }
            }
        }
    }

    public boolean canPlaceRamp(int x, int y, String dir, String type) {
        for (int i = 0; i < L; i++) {
            int ny = 0;
            int nx = 0;
            if ("ho".equals(dir)) {
                if ("up".equals(type)) {
                    nx = x;
                    ny = y - i;
                }
                else {
                    nx = x;
                    ny = y + i;
                }
            }
            else {
                if ("up".equals(type)) {
                    nx = x - i;
                    ny = y;
                }
                else {
                    nx = x + i;
                    ny = y;
                }
            }
            if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                return false;
            }
            if (board[x][y] != board[nx][ny]) {
                return false;
            }
            if (hasUsed[nx][ny]) {
                return false;
            }

        }
        for (int i = 0; i < L; i++) {
            int ny = 0;
            int nx = 0;
            if ("ho".equals(dir)) {
                if ("up".equals(type)) {
                    nx = x;
                    ny = y - i;
                }
                else {
                    nx = x;
                    ny = y + i;
                }
            }
            else {
                if ("up".equals(type)) {
                    nx = x - i;
                    ny = y;
                }
                else {
                    nx = x + i;
                    ny = y;
                }
            }
            hasUsed[nx][ny] = true;
        }
        return true;
    }

    public int solution(int N, int L, int[][] board) {

        for (int i = 0; i < N; i++) {
            goHorizontally(i, 0);
            goVerticallly(0, i);
        }
        return answer;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        System.out.println(T.solution(N, L, board));
    }
}
