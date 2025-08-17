package BOJ.BOJ1238;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Node implements Comparable<Node> {

    int vex, cost;

    Node(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int N, M, X;
    static List<List<Node>> graph, reverseGraph;

    public int[] dijkstra(int start, List<List<Node>> graph) {

        int[] cost = new int[N + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int nowVex = cur.vex;
            int nowCost = cur.cost;
            if (nowCost > cost[nowVex]) {
                continue;
            }
            for (Node to : graph.get(nowVex)) {
                int newCost = nowCost + to.cost;
                if (newCost < cost[to.vex]) {
                    cost[to.vex] = newCost;
                    pq.offer(new Node(to.vex, newCost));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        X = sc.nextInt();
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Node(b, c));
            reverseGraph.get(b).add(new Node(a, c));
        }
        int answer = Integer.MIN_VALUE;
        int[] costToX = T.dijkstra(X, reverseGraph);
        int[] costFromX = T.dijkstra(X, graph);
        for (int i = 1; i <= N; i++) {
            int totCost = costToX[i] + costFromX[i];
            answer = Math.max(answer, totCost);
        }
        System.out.println(answer);
    }
}
