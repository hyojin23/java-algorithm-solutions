package BOJ.BOJ1005;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {

    public int solution(int N, int[] buildTime, List<List<Integer>> graph, int[] indegree, int W) {

        Queue<Integer> q = new LinkedList<>();
        int[] dp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i] = buildTime[i];
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int current = q.poll();
            for (int next : graph.get(current)) {
                dp[next] = Math.max(dp[next], dp[current] + buildTime[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return dp[W];
    }


    public static void main(String[] args) {

        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] buildTime = new int[N + 1];
            int[] indegree = new int[N + 1];
            for (int j = 1; j <= N; j++) {
                buildTime[j] = sc.nextInt();
            }
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) {
                graph.add(new ArrayList<>());
            }
            for (int j = 0; j < K; j++) {
                int X = sc.nextInt();
                int Y = sc.nextInt();
                graph.get(X).add(Y);
                indegree[Y]++;
            }
            int W = sc.nextInt();
            System.out.println(main.solution(N, buildTime, graph, indegree, W));
        }
    }
}
