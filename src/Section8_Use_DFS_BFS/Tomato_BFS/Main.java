package Section8_Use_DFS_BFS.Tomato_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Tomato {

    int x, y;

    public Tomato(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int n, m;
    static int[][] board;
    static int[][] dis;
    static int initCnt = 0;
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(Queue<Tomato> q) {

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Tomato t = q.poll();
                if (t != null) {
                    for (int j = 0; j < 4; j++) {
                        int nx = t.x + dx[j];
                        int ny = t.y + dy[j];
                        if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && board[nx][ny] == 0) {
                            board[nx][ny] = 1;
                            q.offer(new Tomato(nx, ny));
                            dis[nx][ny] = dis[t.x][t.y] + 1;
                        }
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();
        board = new int[n + 1][m + 1];
        dis = new int[n + 1][m + 1];
        Queue<Tomato> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int val = sc.nextInt();
                board[i][j] = val;
                if (val == 1) {
                    q.offer(new Tomato(i, j));
                }
            }
        }

        T.BFS(q);

        int answer = Integer.MIN_VALUE;
        boolean flag = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (board[i][j] == 0) {
                    flag = false;
                }
            }
        }

        if (flag) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    answer = Math.max(answer, dis[i][j]);
                }
            }
            System.out.println(answer);
        }
        else {
            System.out.println(-1);
        }
    }
}
