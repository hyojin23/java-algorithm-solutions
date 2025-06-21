package BOJ.BOJ1697;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int[] ch, dis;

    public int BFS(int N, int K) {

        int[] dx = {1, -1, 2};
        Queue<Integer> q = new LinkedList<>();
        ch[N] = 1;
        q.offer(N);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 2) {
                    nx = cur * dx[i];
                }
                else {
                    nx = cur + dx[i];
                }
                if (nx >= 0 && nx <= 100000 && ch[nx] == 0) {
                    ch[nx] = 1;
                    dis[nx] = dis[cur] + 1;
                    if (nx == K) {
                        return dis[nx];
                    }
                    q.offer(nx);
                }
            }
        }
        return 0;
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        ch = new int[100001];
        dis = new int[100001];
        System.out.println(T.BFS(N, K));
    }
}
