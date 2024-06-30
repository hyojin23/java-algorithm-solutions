package Section8_Use_DFS_BFS.Island_Nation_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

class Island_2nd {

    int x, y;

    public Island_2nd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2nd {

    static int n, answer = 0;
    static int[][] ch, board;

    int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public void BFS(int x, int y) {

        Queue<Island_2nd> q = new LinkedList<>();
        q.offer(new Island_2nd(x, y));
        int cnt = 0;

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {

                Island_2nd cur = q.poll();

                for (int j = 0; j < 8; j++) {

                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= n - 1 && ch[nx][ny] == 0 && board[nx][ny] == 1) {
                        ch[nx][ny] = 1;
                        q.offer(new Island_2nd(nx, ny));
                    }
                }
            }
        }
        cnt++;

        answer += cnt;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        board = new int[n][n];
        ch = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (ch[i][j] == 0 && board[i][j] == 1){
                    ch[i][j] = 1;
                    T.BFS(i, j);
                }
            }
        }

        System.out.println(answer);
    }
}
