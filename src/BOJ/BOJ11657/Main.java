package BOJ.BOJ11657;

import java.util.Scanner;
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

    static int N, M;
    static final long INF = Long.MAX_VALUE;
    static long[] cost;

    public boolean bellmanFord(List<Edge> graph) {
        Arrays.fill(cost, INF);
        cost[1] = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = graph.get(j);
                if (cost[edge.from] != INF && cost[edge.from] + edge.cost < cost[edge.to]) {
                    cost[edge.to] = cost[edge.from] + edge.cost;
                }
            }
        }
        for (int j = 0; j < M; j++) {
            Edge edge = graph.get(j);
            if (cost[edge.from] != INF && cost[edge.from] + edge.cost < cost[edge.to]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        List<Edge> graph = new ArrayList<>();
        cost = new long[N + 1];
        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();
            graph.add(new Edge(from, to, weight));
        }

        if (!T.bellmanFord(graph)) {
            System.out.println(-1);
        }
        else {
            for (int i = 2; i <= N; i++) {
                System.out.println(cost[i] == INF ? -1 : cost[i]);
            }
        }
    }
}
