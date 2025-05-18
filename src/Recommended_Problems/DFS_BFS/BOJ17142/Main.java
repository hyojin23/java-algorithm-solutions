package Recommended_Problems.DFS_BFS.BOJ17142;

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

    static int N, M, answer = Integer.MAX_VALUE, fullSpreadDate, noVirusCnt;
    static int caseCnt;
    static int[] arr;
    static int[][] board, ch;
    static List<Point> vpList;

    public int[][] BFS(int[] arr) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        Queue<Point> q = new LinkedList<>();
        ch = new int[N][N];
        int[][] time = new int[N][N];
        for (int x : arr) {
            Point vp = vpList.get(x);
            ch[vp.x][vp.y] = 1;
            q.offer(vp);
        }

        while(!q.isEmpty()) {
            Point p = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] != 1 && ch[nx][ny] == 0) {
                    time[nx][ny] = time[p.x][p.y] + 1;
                    ch[nx][ny] = 1;
                    q.offer(new Point(nx, ny));
                }
            }
        }
        return time;
    }

    public void DFS(int L, int s) {

        if (L == M) {
            int[][] time = BFS(arr);
            caseCnt++;
            boolean allContaminated = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 0 && ch[i][j] == 0) {
                        noVirusCnt++;
                        allContaminated = false;
                        break;
                    }
                }
                if (!allContaminated) {
                    break;
                }
            }

            fullSpreadDate = 0;
            if (allContaminated) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] == 0 && time[i][j] > fullSpreadDate) {
                            fullSpreadDate = time[i][j];
                        }
                    }
                }
                answer = Math.min(answer, fullSpreadDate);
            }
        }
        else {
            for (int i = s; i < vpList.size(); i++) {
                arr[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        board = new int[N][N];
        arr = new int[M];
        vpList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] == 2) {
                    vpList.add(new Point(i, j));
                }
            }
        }
        T.DFS(0, 0);

        if (caseCnt == noVirusCnt) {
            System.out.println(-1);
        }
        else {
            System.out.println(answer);
        }
    }
}
