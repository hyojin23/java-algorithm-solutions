package BOJ.BOJ1504;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Node implements Comparable<Node> {

    int vex;
    long cost;

    Node(int vex, long cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node ob) {
        return Long.compare(this.cost, ob.cost);
    }
}

public class Main {

    static int N, E, u, v;
    static List<List<Node>> graph;
    static final long INF = (long) 1e18;

    public long dijkstra(int start, int end) {

        long[] cost = new long[N + 1];
        Arrays.fill(cost, INF);
        cost[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowVex = cur.vex;
            long nowCost = cur.cost;
            if (nowCost > cost[nowVex]) {
                continue;
            }
            for (Node to : graph.get(nowVex)) {
                long newCost = nowCost + to.cost;
                if (newCost < cost[to.vex]) {
                    cost[to.vex] = newCost;
                    pq.offer(new Node(to.vex, newCost));
                }
            }
        }
        return cost[end];
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);
        graph = new ArrayList<>();
        N = sc.nextInt();
        E = sc.nextInt();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        u = sc.nextInt();
        v = sc.nextInt();
        long a = T.dijkstra(1, u);
        long b = T.dijkstra(u, v);
        long c = T.dijkstra(v, N);

        long d = T.dijkstra(1, v);
        long e = T.dijkstra(v, u);
        long f = T.dijkstra(u, N);

        long path1 = a == INF || b == INF || c == INF ? INF : a + b + c;
        long path2 = d == INF || e == INF || f == INF ? INF : d + e + f;

        if (path1 == INF && path2 == INF) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(path1, path2));
        }
    }
}
