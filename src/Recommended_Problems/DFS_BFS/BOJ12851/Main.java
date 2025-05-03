package Recommended_Problems.DFS_BFS.BOJ12851;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    int[] dx = {-1, 1, 2};
    static int[] time = new int[100001];
    static int cnt;

    public void BFS(int N, int K) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int nx;
            int x = q.poll();
            if (time[K] > 0 && time[x] + 1 > time[K]) {
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (dx[j] == 2) {
                    nx = x * dx[j];
                }
                else {
                    nx = x + dx[j];
                }
                if (nx >= 0 && nx <= 100000 && (time[nx] == 0 || time[x] + 1 <= time[nx])) {
                    time[nx] = time[x] + 1;
                    q.offer(nx);
                    if (nx == K) {
                        cnt++;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
        }
        else {
            T.BFS(N, K);
            System.out.println(time[K]);
            System.out.println(cnt);
        }
    }
}
