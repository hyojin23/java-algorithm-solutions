package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge_3rd implements Comparable<Edge_3rd> {

    int vex;
    int cost;

    Edge_3rd(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_3rd ob) {
        return this.cost - ob.cost;
    }
}

public class Main_3rd {

    static List<List<Edge_3rd>> graph;
    static int[] dis;

    public void solution(int v) {

        PriorityQueue<Edge_3rd> pq = new PriorityQueue<>();

        pq.offer(new Edge_3rd(v, 0));
        dis[v] = 0;

        while (!pq.isEmpty()) {

            Edge_3rd data = pq.poll();

            int now = data.vex;
            int nowCost = data.cost;

            if (nowCost > dis[now]) continue;

            for (Edge_3rd to : graph.get(now)) {
                if (dis[to.vex] > nowCost + to.cost) {
                    dis[to.vex] = nowCost + to.cost;
                    pq.offer(new Edge_3rd(to.vex, nowCost + to.cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        Main_3rd T = new Main_3rd();
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

            graph.get(a).add(new Edge_3rd(b, c));
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
