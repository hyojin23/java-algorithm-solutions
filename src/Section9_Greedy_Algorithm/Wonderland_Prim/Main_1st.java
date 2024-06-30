package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Edge_1st implements Comparable<Edge_1st> {

    int vex, cost;

    public Edge_1st(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    public int compareTo(Edge_1st ob) {
        return this.cost - ob.cost;
    }
}

public class Main_1st {
    public static void main(String[] args) {

        Main_1st T = new Main_1st();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        List<List<Edge_1st>> graph = new ArrayList<>();
        int[] ch = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge_1st(b, c));
            graph.get(b).add(new Edge_1st(a, c));
        }

        PriorityQueue<Edge_1st> pq = new PriorityQueue<>();
        pq.offer(new Edge_1st(1, 0));

        int answer = 0;
        while (!pq.isEmpty()) {

            Edge_1st eg = pq.poll();
            if (ch[eg.vex] == 0) {

                ch[eg.vex] = 1;
                answer += eg.cost;

                for (Edge_1st ev : graph.get(eg.vex)) {
                    if (ch[ev.vex] == 0) {
                        pq.offer(new Edge_1st(ev.vex, ev.cost));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
