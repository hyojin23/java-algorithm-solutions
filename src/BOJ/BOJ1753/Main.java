package BOJ.BOJ1753;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Edge implements Comparable<Edge> {

    int vex, cost;

    Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static List<List<Edge>> graph;
    static int[] cost;
    public void solution(int startNode) {

        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[startNode] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(startNode, 0));
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int nowVex = cur.vex;
            int nowCost = cur.cost;
            if (nowCost > cost[nowVex]) {
                continue;
            }
            for (Edge next : graph.get(nowVex)) {
                if (nowCost + next.cost < cost[next.vex]) {
                    cost[next.vex] = nowCost + next.cost;
                    pq.offer(new Edge(next.vex, nowCost + next.cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int K = sc.nextInt();
        cost = new int[V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(K);
        for (int i = 1; i <= V; i++) {
            if (cost[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(cost[i]);
            }
        }
    }
}
