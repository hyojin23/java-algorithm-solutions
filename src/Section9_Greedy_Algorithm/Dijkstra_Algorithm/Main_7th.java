package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Edge_7th implements Comparable<Edge_7th> {

    int vex, cost;

    Edge_7th(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge_7th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_7th {

    static List<List<Edge_7th>> graph;
    static int[] dis;

    public void solution(int v) {

        PriorityQueue<Edge_7th> pq = new PriorityQueue<>();
        pq.offer(new Edge_7th(v, 0));
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[v] = 0;

        while (!pq.isEmpty()) {
            Edge_7th edge = pq.poll();
            int nowCost = edge.cost;
            if (nowCost > dis[edge.vex]) {
                continue;
            }
            for (Edge_7th eg : graph.get(edge.vex)) {
                int newCost = nowCost + eg.cost;
                if (newCost < dis[eg.vex]) {
                    dis[eg.vex] = newCost;
                    pq.offer(new Edge_7th(eg.vex, newCost));
                }
            }
        }
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        dis = new int[n + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge_7th(b, c));
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
