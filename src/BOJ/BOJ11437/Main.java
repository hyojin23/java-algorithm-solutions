package BOJ.BOJ11437;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

public class Main {

    static int N;
    static int[] parent, depth;
    static boolean[] visited;
    static List<List<Integer>> graph;

    public static void dfs(int cur, int par, int d) {

        visited[cur] = true;
        parent[cur] = par;
        depth[cur] = d;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next, cur, d + 1);
            }
        }
    }

    public static int lca(int u, int v) {

        while (depth[u] > depth[v]) {
            u = parent[u];
        }
        while (depth[v] > depth[u]) {
            v = parent[v];
        }

        while (u != v) {
            u = parent[u];
            v = parent[v];
        }

        return u;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        parent = new int[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        dfs(1, 0, 0);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(lca(u, v));
        }
    }
}
