package BOJ.BOJ2533;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int[][] dp;

    public static void dfs(int u) {

        visited[u] = true;

        dp[u][1] = 1;
        dp[u][0] = 0;

        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(v);
                dp[u][0] += dp[v][1];                       //u가 얼리어답터가 아닐 때는 내 이웃이 모두 얼리어답터여야 한다.
                dp[u][1] += Math.min(dp[v][0], dp[v][1]);   //u가 얼리어답터일때는 내 이웃이 얼리어답터건 아니건 상관 없다.
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        dp = new int[N + 1][2];
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
