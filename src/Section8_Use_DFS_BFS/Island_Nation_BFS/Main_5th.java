package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Point_5th {

    int x, y;

    Point_5th(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_5th {

    static int n;
    static int[][] arr;
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y) {

        Queue<Point_5th> q = new LinkedList<>();
        q.offer(new Point_5th(x, y));

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Point_5th p = q.poll();
                for (int j = 0; j < 8; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.offer(new Point_5th(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    answer++;
                    arr[i][j] = 0;
                    T.BFS(i, j);
                }
            }
        }
        System.out.println(answer);
    }
}
