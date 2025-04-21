package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int vex, cost;

    Edge (int vex, int cost) {
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
    static int[] dis;

    public void solution(int n, int m) {

        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.cost > dis[edge.vex]) {
                continue;
            }
            for (Edge eg : graph.get(edge.vex)) {
                int nc = dis[edge.vex] + eg.cost;
                if (nc < dis[eg.vex]) {
                    dis[eg.vex] = nc;
                    pq.offer(new Edge(eg.vex, nc));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }
        T.solution(n, m);
        for (int i = 2; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            }
            else {
                System.out.println(i + " : " + dis[i]);
            }
        }
    }
}
