package Recommended_Problems.DFS_BFS.BOJ16918;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y, t;

    Point(int x, int y, int t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {

    public void solution(int R, int C, int N, char[][] board, int[][] bombTimer, Queue<Point> q) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int t = 2; t <= N; t++) {
            if (t % 2 == 0) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == '.') {
                            board[i][j] = 'O';
                            q.offer(new Point(i, j, t + 3));
                            bombTimer[i][j] = t + 3;
                        }
                    }
                }
            }
            else {
                while (!q.isEmpty()) {
                    if (q.peek().t != t) {
                        break;
                    }
                    Point p = q.poll();
                    if (bombTimer[p.x][p.y] != t) {
                        continue;
                    }
                    for (int i = 0; i < 4; i++) {
                        int nx = p.x + dx[i];
                        int ny = p.y + dy[i];
                        if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                            board[nx][ny] = '.';
                            if (bombTimer[nx][ny] != t) {
                                bombTimer[nx][ny] = -1;
                            }
                        }
                    }
                    board[p.x][p.y] = '.';
                }
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[R][C];
        Queue<Point> q = new LinkedList<>();
        int[][] bombTimer = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == 'O') {
                    q.offer(new Point(i, j, 3));
                    bombTimer[i][j] = 3;
                }
            }
        }
        T.solution(R, C, N, board, bombTimer, q);
    }
}
