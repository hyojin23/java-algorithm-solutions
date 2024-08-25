package Section9_Greedy_Algorithm.Wonderland_Prim;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;

class Edge_2nd implements Comparable<Edge_2nd> {

    int v, cost;

    Edge_2nd(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge_2nd ob) {
        return this.cost - ob.cost;
    }
}

public class Main_2nd {

    static int[] ch;
    static List<List<Edge_2nd>> graph;
    public int solution(int v, int cost) {

        int answer = 0;
        PriorityQueue<Edge_2nd> pq = new PriorityQueue<>();

        pq.offer(new Edge_2nd(v, cost));

        while (!pq.isEmpty()) {
            Edge_2nd edge = pq.poll();
            int ev = edge.v;
            if (ch[ev] == 0) {
                ch[ev] = 1;
                answer += edge.cost;
                for (Edge_2nd e : graph.get(ev)) {
                    if (ch[e.v] == 0) {
                        pq.offer(e);
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Main_2nd T = new Main_2nd();
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

            graph.get(a).add(new Edge_2nd(b, c));
            graph.get(b).add(new Edge_2nd(a, c));
        }

        System.out.println(T.solution(1, 0));
    }
}
