package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

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

    static int ch[];
    static List<List<Edge_5th>> graph;

    public int solution(int v, int e) {

        PriorityQueue<Edge_5th> pq = new PriorityQueue<>();
        pq.offer(new Edge_5th(1, 0));
        int answer = 0;

        while (!pq.isEmpty()) {
            Edge_5th edge = pq.poll();
            if (ch[edge.vex] == 0) {
                ch[edge.vex] = 1;
                answer += edge.cost;
                for (Edge_5th eg : graph.get(edge.vex)) {
                    if (ch[eg.vex] == 0) {
                        pq.offer(eg);
                    }
                }
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        Main_5th T = new Main_5th();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ch = new int[v + 1];
        graph = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge_5th(b, c));
            graph.get(b).add(new Edge_5th(a, c));
        }

        System.out.println(T.solution(v, e));
    }
}
