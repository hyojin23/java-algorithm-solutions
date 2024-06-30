package Section8_Use_DFS_BFS.Tomato_BFS;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Tomato_2nd {

    int x, y;

    public Tomato_2nd(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main_2nd {

    static int[][] box;
    static int n, m, ut;


    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int BFS(List<Tomato_2nd> list) {

        Queue<Tomato_2nd> q = new LinkedList<>();

        for (Tomato_2nd t : list) {
            q.offer(t);
        }

        int rt = 0;
        int L = 0;

        while (!q.isEmpty()) {

            int len = q.size();
            for (int i = 0; i < len; i++) {

                Tomato_2nd t = q.poll();

                for (int j = 0; j < 4; j++) {

                    int nx = t.x + dx[j];
                    int ny = t.y + dy[j];

                    if (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= m - 1 && box[nx][ny] == 0) {
                        box[nx][ny] = 1;
                        rt++;
                        q.offer(new Tomato_2nd(nx, ny));
                    }
                }
            }
            L++;

            if (rt == ut) {
                return L;
            }
        }

        if (rt < ut) {
            return -1;
        }

        return 0;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        box = new int[n][m];
        List<Tomato_2nd> list = new ArrayList<>();

        ut = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int t = sc.nextInt();
                box[i][j] = t;

                if (t == 0) {
                    ut++;
                }

                if (t == 1) {
                    list.add(new Tomato_2nd(i, j));
                }
            }
        }

        System.out.println(T.BFS(list));
    }
}
