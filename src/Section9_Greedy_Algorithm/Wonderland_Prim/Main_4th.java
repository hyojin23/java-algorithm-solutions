package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Edge_4th implements Comparable<Edge_4th> {

    int v, cost;

    Edge_4th(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_4th ob) {
        return this.cost - ob.cost;
    }
}

public class Main_4th {

    static int[] ch;
    static List<List<Edge_4th>> graph;
    public int solution(int v, int cost) {

        int answer = 0;
        PriorityQueue<Edge_4th> pq = new PriorityQueue<>();

        pq.offer(new Edge_4th(v, cost));

        while (!pq.isEmpty()) {
            Edge_4th edge = pq.poll();
            int ev = edge.v;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += edge.cost;
                for (Edge_4th e : graph.get(ev)) {
                    if (ch[e.v] == 0) {
                        pq.offer(e);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_4th T = new Main_4th();
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

            graph.get(a).add(new Edge_4th(b, c));
            graph.get(b).add(new Edge_4th(a, c));
        }

        System.out.println(T.solution(1, 0));
    }
}
