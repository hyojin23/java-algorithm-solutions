package Recommended_Problems.DFS_BFS.BOJ2210;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.TreeSet;

class Point {

    int x, y;
    String s;

    Point (int x, int y, String s) {
        this.x = x;
        this.y = y;
        this.s = s;
    }
}

public class Main {

    static int[][] board;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static TreeSet<String> ts;

    public void BFS(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y, String.valueOf(board[x][y])));
        int L = 1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(p.s);
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && L <= 5) {
                        String ns = sb.append(board[nx][ny]).toString();
                        q.offer(new Point(nx, ny, ns));
                        if (L == 5) {
                            ts.add(ns);
                        }
                    }
                }
            }
            L++;
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        board = new int[5][5];
        ts = new TreeSet<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                T.BFS(i, j);
            }
        }
        System.out.println(ts.size());
    }
}
