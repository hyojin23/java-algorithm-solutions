package Recommended_Problems.DFS_BFS.BOJ4991;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
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

    static int w, h, answer;
    static char[][] board;
    static List<Point> list;
    static int[] combi, ch;
    static boolean[][] visited;
    static int[][] graph;
    static boolean isNotVisitable;

    public int BFS(Point s, Point e) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        visited = new boolean[h][w];
        Queue<Point> q = new LinkedList<>();
        visited[s.x][s.y] = true;
        q.offer(s);
        int L = 0;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point cur = q.poll();
                if (cur.x == e.x && cur.y == e.y) {
                    return L;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && board[nx][ny] != 'x') {
                        if (!visited[nx][ny]) {
                            visited[nx][ny] = true;
                            q.offer(new Point(nx, ny));
                        }
                    }
                }
            }
            L++;
        }
        return -1;
    }
    public void combi(int s, int L) {

        if (isNotVisitable) {
            return;
        }

        if (L == 2) {
            int v1 = combi[0];
            int v2 = combi[1];
            int minDis = BFS(list.get(v1), list.get(v2));
            if (minDis == -1) {
                isNotVisitable = true;
            }
            graph[v1][v2] = minDis;
            graph[v2][v1] = minDis;
        }
        else {
            for (int i = s; i < list.size(); i++) {
                combi[L] = i;
                combi(i + 1, L + 1);
            }
        }
    }

    public void permute(int L, int v1, int sum) {
        if (L == list.size() - 1) {
            answer = Math.min(answer, sum);
        }
        else {
            for (int i = 1; i < list.size(); i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    permute(L + 1, i, sum + graph[v1][i]);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) {
                break;
            }
            sc.nextLine();
            board = new char[h][w];
            list = new ArrayList<>();
            combi = new int[2];
            for (int i = 0; i < h; i++) {
                String str = sc.nextLine();
                for (int j = 0; j < w; j++) {
                    board[i][j] = str.charAt(j);
                    if (board[i][j] == 'o') {
                        list.add(new Point(i, j));
                    }
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (board[i][j] == '*') {
                        list.add(new Point(i, j));
                    }
                }
            }
            graph = new int[list.size()][list.size()];
            ch = new int[list.size()];
            isNotVisitable = false;
            T.combi(0, 0);
            answer = Integer.MAX_VALUE;
            if (isNotVisitable) {
                System.out.println(-1);
            }
            else {
                T.permute(0, 0, 0);
                System.out.println(answer);
            }
        }
    }
}
