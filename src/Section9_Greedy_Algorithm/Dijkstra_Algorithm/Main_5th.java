package Section9_Greedy_Algorithm.Dijkstra_Algorithm;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Arrays;

class Edge_5th implements Comparable<Edge_5th> {

    int vex, cost;

    Edge_5th(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_5th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_5th {

    static List<List<Edge_5th>> graph;
    static int[] answer;

    public void solution(int v) {

        PriorityQueue<Edge_5th> pq = new PriorityQueue<>();
        pq.offer(new Edge_5th(v, 0));

        while (!pq.isEmpty()) {
            Edge_5th e = pq.poll();

            int nowVex = e.vex;
            int nowCost = e.cost;

            if (nowCost > answer[nowVex]) {
                continue;
            }

            for (Edge_5th edge : graph.get(nowVex)) {
                if (nowCost + edge.cost < answer[edge.vex]) {
                    answer[edge.vex] = nowCost + edge.cost;
                    pq.offer(new Edge_5th(edge.vex, nowCost + edge.cost));
                }
            }
        }
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
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
            graph.get(a).add(new Edge_5th(b, c));
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
