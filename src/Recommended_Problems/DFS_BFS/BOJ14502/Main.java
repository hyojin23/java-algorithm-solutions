package Recommended_Problems.DFS_BFS.BOJ14502;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;
    static int N, M, safeZone, answer = Integer.MIN_VALUE;
    static Queue<Point> q;
    static List<Point> list;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int BFS() {
        Queue<Point> q = new LinkedList<>();
        int virusZone = 0;
        int[][] ch = new int[N][M];
        for (Point p : list) {
            q.offer(p);
        }
        while(!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point p = q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0 && ch[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        ch[nx][ny] = 1;
                        virusZone++;
                    }
                }
            }
        }
        return virusZone;
    }

    public void DFS(int row, int wallCnt) {

        if (wallCnt == 3) {
            int virusZone = BFS();
            answer = Math.max(answer, safeZone - virusZone - 3);
        }
        else {
            for (int i = row; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        board[i][j] = 1;
                        DFS(i, wallCnt + 1);
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][M];
        q  = new LinkedList<>();
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 0) {
                    safeZone++;
                }
                if (board[i][j] == 2) {
                    list.add(new Point(i, j));
                }
            }
        }
        T.DFS(0, 0);
        System.out.println(answer);
    }
}
