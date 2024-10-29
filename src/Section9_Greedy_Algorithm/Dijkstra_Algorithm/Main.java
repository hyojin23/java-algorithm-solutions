package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

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
    static int[] answer;

    public void solution(int v) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));

        while (!pq.isEmpty()) {
            Edge e = pq.poll();

            int nowVex = e.vex;
            int nowCost = e.cost;

            if (nowCost > answer[nowVex]) {
                continue;
            }

            for (Edge edge : graph.get(nowVex)) {
                if (nowCost + edge.cost < answer[edge.vex]) {
                    answer[edge.vex] = nowCost + edge.cost;
                    pq.offer(new Edge(edge.vex, nowCost + edge.cost));
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

        answer = new int[n + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[1] = 0;

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
        }

        T.solution(1);

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
