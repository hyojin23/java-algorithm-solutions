package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

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

    static int[] ch;
    static List<List<Edge>> graph;
    public int solution(int v, int cost) {

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        pq.offer(new Edge(v, cost));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int ev = edge.v;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += edge.cost;
                for (Edge e : graph.get(ev)) {
                    if (ch[e.v] == 0) {
                        pq.offer(e);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main T = new Main();
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();
        ch = new int[v + 1];
        graph = new ArrayList<>();

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }

        System.out.println(T.solution(1, 0));
    }
}
