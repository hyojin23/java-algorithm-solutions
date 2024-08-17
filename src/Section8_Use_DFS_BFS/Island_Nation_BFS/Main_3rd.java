package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Island_3rd {

    int x, y;

    Island_3rd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_3rd {

    static int n, answer = 0;
    static int[][] arr;
    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y) {

        Queue<Island_3rd> q = new LinkedList<>();

        q.offer(new Island_3rd(x, y));
        answer++;

        while (!q.isEmpty()) {

            int len = q.size();

            for (int i = 0; i < len; i++) {

                Island_3rd is = q.poll();

                for (int j = 0; j < 8; j++) {

                    int nx = is.x + dx[j];
                    int ny = is.y + dy[j];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 1) {
                        arr[nx][ny] = 0;
                        q.offer(new Island_3rd(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j< n; j++) {
                if (arr[i][j] == 1) {
                    arr[i][j] = 0;
                    T.BFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
