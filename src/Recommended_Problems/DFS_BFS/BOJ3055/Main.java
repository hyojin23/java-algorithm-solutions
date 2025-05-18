package Recommended_Problems.DFS_BFS.BOJ3055;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

class Point {

    int x, y;
    char t;

    Point(int x, int y, char t) {
        this.x = x;
        this.y = y;
        this.t = t;
    }
}

public class Main {

    static int R, C;
    static char[][] board;
    static int[][] ch, time;

    public int BFS(List<Point> wList, Point hPoint) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();
        for (Point w : wList) {
            ch[w.x][w.y] = 2;
            q.offer(new Point(w.x, w.y, 'w'));
        }
        ch[hPoint.x][hPoint.y] = 1;
        q.offer(hPoint);
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < R && ny >= 0 && ny < C && board[nx][ny] != 'X') {
                    if (p.t == 'w') {
                        if (board[nx][ny] != 'D') {
                            if (ch[nx][ny] != 2) {
                                ch[nx][ny] = 2;
                                board[nx][ny] = '*';
                                q.offer(new Point(nx, ny, 'w'));
                            }
                        }
                    }
                    else if (p.t == 's') {
                        if (ch[nx][ny] == 0) {
                            ch[nx][ny] = 1;
                            time[nx][ny] = time[p.x][p.y] + 1;
                            if (board[nx][ny] == 'D') {
                                return time[nx][ny];
                            }
                            q.offer(new Point(nx, ny, 's'));
                        }
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        board = new char[R][C];
        ch = new int[R][C];
        time = new int[R][C];
        List<Point> wList = new ArrayList<>();
        Point hPoint = null;
        for (int i = 0; i < R; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
                if (board[i][j] == '*') {
                    wList.add(new Point(i, j, 'w'));
                }
                if (board[i][j] == 'S') {
                    hPoint = new Point(i, j, 's');
                }
            }
        }
        int answer = T.BFS(wList, hPoint);
        if (answer == 0) {
            System.out.println("KAKTUS");
        }
        else {
            System.out.println(answer);
        }
    }
}
