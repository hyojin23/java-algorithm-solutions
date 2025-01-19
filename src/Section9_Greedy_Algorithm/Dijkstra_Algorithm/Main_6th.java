package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Edge_6th implements Comparable<Edge_6th> {

    int vex, cost;

    Edge_6th(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_6th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_6th {

    static List<List<Edge_6th>> graph;
    static int[] dis;

    public void solution(int v) {

        PriorityQueue<Edge_6th> pq = new PriorityQueue<>();
        pq.offer(new Edge_6th(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {

            Edge_6th edge = pq.poll();
            int nowVex = edge.vex;
            int nowCost = edge.cost;

            if (nowCost > dis[nowVex]) {
                continue;
            }

            for (Edge_6th e : graph.get(nowVex)) {
                if (nowCost + e.cost < dis[e.vex]) {
                    int newCost = nowCost + e.cost;
                    dis[e.vex] = newCost;
                    pq.offer(new Edge_6th(e.vex, newCost));
                }
            }
        }
    }

    public static void main(String[] argss) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge_6th(b, c));
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
