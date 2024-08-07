package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge_2nd implements Comparable<Edge_2nd>{

    int vex, cost;

    public Edge_2nd(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_2nd o) {
        return this.cost - o.cost;
    }
}


public class Main_2nd {

    static int n, m;
    static List<List<Edge_2nd>> graph;
    static int dis[];

    public void solution(int v) {

        PriorityQueue<Edge_2nd> pq = new PriorityQueue<>();

        pq.offer(new Edge_2nd(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {

            Edge_2nd e = pq.poll();

            int nowVex = e.vex;
            int nowCost = e.cost;

            if (nowCost > dis[nowVex]) continue;

            for (Edge_2nd edge : graph.get(nowVex)) {
                if (nowCost + edge.cost < dis[edge.vex]) {

                    int newCost = nowCost + edge.cost;

                    dis[edge.vex] = newCost;

                    pq.offer(new Edge_2nd(edge.vex, newCost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge_2nd(b, c));
        }
        T.solution(1);

        for (int i = 2; i <= n; i++) {

            if (dis[i] != Integer.MAX_VALUE) {

                System.out.println(i + " : " + dis[i]);
            }
            else {
                System.out.println(i + " : impossible");
            }
        }
    }
}
