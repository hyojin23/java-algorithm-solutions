package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge implements Comparable<Edge> {

    int vex, cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge ob) {
        return this.cost - ob.cost;
    }
}

public class Main {
    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Edge>> graph = new ArrayList<>();
        int[] ch = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));

        int answer = 0;
        while (!pq.isEmpty()) {

            Edge eg = pq.poll();
            if (ch[eg.vex] == 0) {

                ch[eg.vex] = 1;
                answer += eg.cost;

                for (Edge ev : graph.get(eg.vex)) {
                    if (ch[ev.vex] == 0) {
                        pq.offer(new Edge(ev.vex, ev.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
