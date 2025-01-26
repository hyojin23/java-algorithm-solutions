package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

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
    static int[] ch;

    public int solution(int v) {

        PriorityQueue<Edge_6th> pq = new PriorityQueue<>();
        pq.offer(new Edge_6th(v, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            Edge_6th cur = pq.poll();
            if (ch[cur.vex] == 0) {
                ch[cur.vex] = 1;
                sum += cur.cost;
                for (Edge_6th edge : graph.get(cur.vex)) {
                    if (ch[edge.vex] == 0) {
                        pq.offer(edge);
                    }
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {

        Main_6th T = new Main_6th();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        graph = new ArrayList<>();
        ch = new int[v + 1];

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge_6th(b, c));
            graph.get(b).add(new Edge_6th(a, c));
        }

        System.out.println(T.solution(1));
    }
}
