package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int v, cost;

    Edge(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {

    static int n;

    public int[] solution(List<List<Edge>> list) {

        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[1] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        while (!pq.isEmpty()) {

            Edge edge = pq.poll();
            int nowVex = edge.v;
            int nowCost = edge.cost;

            if (nowCost > cost[nowVex]) {
                continue;
            }

            for (Edge e : list.get(nowVex)) {
                int nc = nowCost + e.cost;
                if (nc < cost[e.v]) {
                    cost[e.v] = nc;
                    pq.offer(new Edge(e.v, nc));
                }
            }
        }
        return cost;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Edge>> list =  new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int cost = sc.nextInt();

            list.get(v1).add(new Edge(v2, cost));
        }

        int[] answer = T.solution(list);

        for (int i = 2; i <= n; i++) {
            if (answer[i] == Integer.MAX_VALUE) {
                System.out.println(i + " : impossible");
            }
            else {
                System.out.println(i + " : " + answer[i]);
            }
        }
    }
}
