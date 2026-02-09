package BOJ.BOJ1865;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Edge {

    int from, to, cost;

    Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}

public class Main {

    public static boolean bellmanFord(int N, List<Edge> edges) {

        long[] dist = new long[N + 1];

        for (int i = 1; i <= N - 1; i++) {
            for (Edge e : edges) {
                if (dist[e.from] != Long.MAX_VALUE && dist[e.from] + e.cost < dist[e.to]) {
                    dist[e.to] = dist[e.from] + e.cost;
                }
            }
        }

        for (Edge e : edges) {
            if (dist[e.from] != Long.MAX_VALUE && dist[e.from] + e.cost < dist[e.to]) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int TC = Integer.parseInt(br.readLine());

        for (int t = 0; t < TC; t++) {
            List<Edge> edges = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, T));
                edges.add(new Edge(E, S, T));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                edges.add(new Edge(S, E, -T));
            }

            boolean hasNegativeCycle = bellmanFord(N, edges);
            if (hasNegativeCycle) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
