package BOJ.BOJ13549;

import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {

    public int BFS(int N, int K) {
        int[] move = {1, -1, 2};
        int[] time = new int[100001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 0; i < 3; i++) {
                int nx;
                int cost;
                if (i == 2) {
                    nx = cur * move[i];
                    cost = time[cur];
                }
                else {
                    nx = cur + move[i];
                    cost = time[cur] + 1;
                }
                if (nx >= 0 && nx <= 100_000 && cost < time[nx]) {
                    time[nx] = cost;
                    q.offer(nx);
                }
            }
        }
        return time[K];
    }


    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        System.out.println(T.BFS(N, K));
    }
}
