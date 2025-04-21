package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

    static int[] ch;

    public int solution(int vex, int cost, List<List<Edge_7th>> graph) {

        int sum =0;
        PriorityQueue<Edge_7th> pq = new PriorityQueue<>();
        pq.offer(new Edge_7th(vex, cost));
        while (!pq.isEmpty()) {
            Edge_7th edge = pq.poll();
            if (ch[edge.vex] == 0) {
                sum += edge.cost;
                ch[edge.vex] = 1;
                int nowVex = edge.vex;
                for (Edge_7th e : graph.get(nowVex)) {
                    if (ch[e.vex] == 0) {
                        pq.offer(new Edge_7th(e.vex, e.cost));
                    }
                }
            }
        }
        return sum;
    }


    public static void main(String[] args) {

        Main_7th T = new Main_7th();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        ch = new int[v + 1];
        List<List<Edge_7th>> graph = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge_7th(b, c));
            graph.get(b).add(new Edge_7th(a, c));
        }
        System.out.println(T.solution(1, 0, graph));
    }
}
