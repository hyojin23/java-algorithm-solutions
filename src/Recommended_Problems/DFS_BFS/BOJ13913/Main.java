package Recommended_Problems.DFS_BFS.BOJ13913;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    static int N, K;
    static final int max = 200_000;
    static int[] time = new int[max + 4];
    static int[] prePos = new int[max + 4];

    public void BFS(int N, int K) {

        Queue<Integer> q = new LinkedList<>();
        time[N] = 1;
        q.offer(N);
        while (!q.isEmpty()) {
            int now = q.poll();
            int[] nextArr = {now - 1, now + 1, now * 2};
            for (int next : nextArr) {
                if (next >= 0 && next <= max && time[next] == 0) {
                    time[next] = time[now] + 1;
                    prePos[next] = now;
                    q.offer(next);
                }
            }
        }
    }

    public void print(int pos) {

        if (pos == N) {
            System.out.print(pos + " ");
            return;
        }
        else {
            print(prePos[pos]);
            System.out.print(pos + " ");
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        T.BFS(N, K);
        System.out.println(time[K] - 1);
        T.print(K);
    }
}
