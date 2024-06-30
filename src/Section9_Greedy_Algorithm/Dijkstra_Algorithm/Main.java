package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int vex;
    int cost;

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
    static int[] dis;

    public void solution(int v) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {

            Edge data = pq.poll();

            int now = data.vex;
            int nowCost = data.cost;

            if (nowCost > dis[now]) continue;

            for (Edge to : graph.get(now)) {
                if (dis[to.vex] > nowCost + to.cost) {
                    dis[to.vex] = nowCost + to.cost;
                    pq.offer(new Edge(to.vex, nowCost + to.cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
        }
        T.solution(1);

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
